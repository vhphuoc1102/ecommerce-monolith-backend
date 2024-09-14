package com.phuocvh.common.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiError {
  private String module;

  private HttpStatus status;

  private String message;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private String debug;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;

  private List<ApiSubError> errors;

  public ApiError(String module) {
    this.module = module;
    this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    this.timestamp = LocalDateTime.now();
    this.errors = new ArrayList<>();
  }

  public ApiError withStatus(HttpStatus status) {
    this.status = status;
    return this;
  }

  public ApiError withMessage(String message) {
    this.message = message;
    return this;
  }

  public ApiError withDebug(Throwable ex) {
    this.debug = ex.getLocalizedMessage();
    return this;
  }

  public ApiError withSubError(ApiSubError subError) {
    this.errors.add(subError);
    return this;
  }

  public ApiError withSubErrors(List<ApiSubError> subErrors) {
    this.errors.addAll(subErrors);
    return this;
  }
}
