package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlbumType {
  PRODUCT(1),
  COMMENT(2),
  ARTICLE(3),
  OTHER(4);
  private final int value;
}
