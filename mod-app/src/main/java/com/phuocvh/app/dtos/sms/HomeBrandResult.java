package com.phuocvh.app.dtos.sms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HomeBrandResult {
  private String brandName;
  private Integer brandId;
  private String pic;
}
