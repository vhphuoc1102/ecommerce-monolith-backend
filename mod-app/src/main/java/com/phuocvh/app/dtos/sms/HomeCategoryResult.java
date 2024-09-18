package com.phuocvh.app.dtos.sms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HomeCategoryResult {
  private String categoryName;
  private Integer categoryId;
  private String pic;
}
