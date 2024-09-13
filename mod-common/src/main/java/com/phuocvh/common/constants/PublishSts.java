package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PublishSts {
  UNPUBLISHED(0),
  PUBLISHED(1);

  private final int value;
}
