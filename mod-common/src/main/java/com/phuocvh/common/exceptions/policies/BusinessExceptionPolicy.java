package com.phuocvh.common.exceptions.policies;

import org.springframework.http.HttpStatus;

public interface BusinessExceptionPolicy extends ExceptionPolicy {
  HttpStatus getHttpStatus();
}
