package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RecommendSts {
  NOT_RECOMMEND(0),
  RECOMMEND(1);

  private final int value;
}
