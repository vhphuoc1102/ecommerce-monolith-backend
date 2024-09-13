package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PreviewSts {
  NOT_PREVIEW(0),
  PREVIEW(1);

  private final int value;
}
