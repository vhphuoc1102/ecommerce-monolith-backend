package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductSubjectType {
  NEW_ARRIVAL(0, "New Arrival"),
  BEST_SELLER(1, "Best Seller"),
  RECOMMENDED(2, "Recommended"),
  CATEGORY(3, "Category"),
  BRAND(4, "Brand"),
  ;

  private final int value;

  private final String name;
}
