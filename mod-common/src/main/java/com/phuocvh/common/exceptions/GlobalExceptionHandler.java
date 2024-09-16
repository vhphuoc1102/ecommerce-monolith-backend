package com.phuocvh.common.exceptions;

import com.phuocvh.common.exceptions.dtos.ErrorResponse;
import com.phuocvh.common.exceptions.dtos.ErrorResponseBuilder;
import com.phuocvh.common.exceptions.dtos.InvalidParam;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<Object> handleUncaughtException(
      final Exception ex, final ServletWebRequest request) {
    log(ex, request);
    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            Exception.class.getSimpleName(),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
            ex.getLocalizedMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
  }

  @ExceptionHandler({BusinessException.class})
  public ResponseEntity<Object> handleBusinessException(
      final BusinessException ex, final ServletWebRequest request) {
    log(ex, request);
    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            ex.getCode(), ex.getMessage(), ex.getLocalizedMessage(), ex.getHttpStatus());
    return ResponseEntity.status(ex.getHttpStatus()).body(errorResponseDto);
  }

  @ExceptionHandler({ApplicationException.class})
  public ResponseEntity<Object> handleApplicationException(
      final ApplicationException ex, final ServletWebRequest request) {
    log(ex, request);
    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            ex.getCode(),
            ex.getMessage(),
            ex.getLocalizedMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
  }

  @ExceptionHandler(value = {ConstraintViolationException.class})
  public ResponseEntity<Object> handleConstraintViolationException(
      final ConstraintViolationException ex, final ServletWebRequest request) {
    log(ex, request);

    final List<InvalidParam> invalidParameters = new ArrayList<>();
    ex.getConstraintViolations()
        .forEach(
            constraintViolation -> {
              final Iterator<Path.Node> it = constraintViolation.getPropertyPath().iterator();
              if (it.hasNext()) {
                try {
                  it.next();
                  final Path.Node n = it.next();
                  final InvalidParam invalidParam = new InvalidParam();
                  invalidParam.setParam(n.getName());
                  invalidParam.setMessage(constraintViolation.getMessage());
                  invalidParameters.add(invalidParam);
                } catch (final Exception e) {
                  log.warn("Can't extract the information about constraint violation");
                }
              }
            });

    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            ConstraintViolationException.class.getSimpleName(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            HttpStatus.BAD_REQUEST,
            ex.getLocalizedMessage(),
            invalidParameters);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    log(ex, (ServletWebRequest) request);
    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            HttpMessageNotReadableException.class.getSimpleName(),
            ex.getMessage(),
            ex.getLocalizedMessage(),
            HttpStatus.BAD_REQUEST);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    log(ex, (ServletWebRequest) request);
    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            HttpRequestMethodNotSupportedException.class.getSimpleName(),
            ex.getMessage(),
            ex.getLocalizedMessage(),
            HttpStatus.METHOD_NOT_ALLOWED);
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorResponseDto);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    log(ex, (ServletWebRequest) request);
    final List<InvalidParam> invalidParameters =
        ex.getBindingResult().getFieldErrors().stream()
            .map(
                fieldError ->
                    InvalidParam.builder()
                        .param(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
            .collect(Collectors.toList());

    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            MethodArgumentNotValidException.class.getSimpleName(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            HttpStatus.BAD_REQUEST,
            ex.getLocalizedMessage(),
            invalidParameters);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
  }

  @ExceptionHandler(ServletRequestBindingException.class)
  protected ResponseEntity<Object> handleServletRequestBindingException(
      ServletRequestBindingException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    log(ex, (ServletWebRequest) request);

    final String missingParameter;
    final String missingParameterType;

    if (ex instanceof MissingRequestHeaderException) {
      missingParameter = ((MissingRequestHeaderException) ex).getHeaderName();
      missingParameterType = "header";
    } else if (ex instanceof MissingServletRequestParameterException) {
      missingParameter = ((MissingServletRequestParameterException) ex).getParameterName();
      missingParameterType = "query";
    } else if (ex instanceof MissingPathVariableException) {
      missingParameter = ((MissingPathVariableException) ex).getVariableName();
      missingParameterType = "path";
    } else {
      missingParameter = "unknown";
      missingParameterType = "unknown";
    }

    final InvalidParam missingParameterDto =
        InvalidParam.builder()
            .param(missingParameter)
            .message(
                String.format(
                    "Missing %s parameter with name '%s'", missingParameterType, missingParameter))
            .build();

    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            ServletRequestBindingException.class.getSimpleName(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            HttpStatus.BAD_REQUEST,
            ex.getLocalizedMessage(),
            Collections.singletonList(missingParameterDto));

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
  }

  @ExceptionHandler(TypeMismatchException.class)
  protected ResponseEntity<Object> handleTypeMismatch(
      TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    log(ex, (ServletWebRequest) request);

    String parameter = ex.getPropertyName();
    if (ex instanceof MethodArgumentTypeMismatchException) {
      parameter = ((MethodArgumentTypeMismatchException) ex).getName();
    }

    final ErrorResponse errorResponseDto =
        ErrorResponseBuilder.build(
            TypeMismatchException.class.getSimpleName(),
            String.format(
                "Unexpected type specified for '%s' parameter. Required '%s'",
                parameter, ex.getRequiredType()),
            ex.getLocalizedMessage(),
            HttpStatus.BAD_REQUEST);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
  }

  @ExceptionHandler(MissingPathVariableException.class)
  protected ResponseEntity<Object> handleMissingPathVariable(
      MissingPathVariableException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    return handleServletRequestBindingException(ex, headers, status, request);
  }

  @ExceptionHandler(MissingRequestHeaderException.class)
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      MissingServletRequestParameterException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    log(ex, (ServletWebRequest) request);
    return handleServletRequestBindingException(ex, headers, status, request);
  }

  private void log(final Exception ex, final ServletWebRequest request) {
    final Optional<HttpMethod> httpMethod;
    final Optional<String> requestUrl;

    final Optional<ServletWebRequest> possibleIncomingNullRequest = Optional.ofNullable(request);
    if (possibleIncomingNullRequest.isPresent()) {
      // get the HTTP Method
      httpMethod = Optional.of(possibleIncomingNullRequest.get().getHttpMethod());
      requestUrl =
          Optional.of(possibleIncomingNullRequest.get().getRequest().getRequestURL().toString());
    } else {
      httpMethod = Optional.empty();
      requestUrl = Optional.empty();
    }

    log.error(
        "Request {} {} failed with exception reason: {}",
        (httpMethod.isPresent() ? httpMethod.get() : "'null'"),
        (requestUrl.orElse("'null'")),
        ex.getMessage(),
        ex);
  }
}
