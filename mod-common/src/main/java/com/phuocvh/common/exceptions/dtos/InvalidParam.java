package com.phuocvh.common.exceptions.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvalidParam {
  private String param;
  private String message;
}
