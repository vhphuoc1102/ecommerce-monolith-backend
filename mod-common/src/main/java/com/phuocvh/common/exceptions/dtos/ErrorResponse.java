package com.phuocvh.common.exceptions.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  private String module;
  private String code;
  private String message;
  private String debug;
  private Integer httpStatus;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private LocalDateTime timestamp;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<InvalidParam> invalidParams;
}
