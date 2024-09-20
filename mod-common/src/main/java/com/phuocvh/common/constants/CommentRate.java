package com.phuocvh.common.constants;

import lombok.Getter;

@Getter
public enum CommentRate {
  ONE_STAR(1),
  TWO_STAR(2),
  THREE_STAR(3),
  FOUR_STAR(4),
  FIVE_STAR(5);

  private final int value;

  CommentRate(int value) {
    this.value = value;
  }
}
