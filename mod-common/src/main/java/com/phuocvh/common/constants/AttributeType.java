package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AttributeType {
  PARAMETER(0),
  SPECIFICATION(1);

  private final int value;
}
