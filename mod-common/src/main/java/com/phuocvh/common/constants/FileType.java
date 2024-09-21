package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileType {
  IMAGE(1),
  VIDEO(2),
  AUDIO(3),
  DOCUMENT(4),
  OTHER(5);
  private final int value;
}
