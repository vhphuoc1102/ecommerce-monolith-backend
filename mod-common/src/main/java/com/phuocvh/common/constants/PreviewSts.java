package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
// Check if the product is in preview mode or not
// If true, the product is in preview mode, cannot be placed
// If false, the product is not in preview mode, can be placed
public enum PreviewSts {
  NOT_PREVIEW(0),
  PREVIEW(1);

  private final int value;
}
