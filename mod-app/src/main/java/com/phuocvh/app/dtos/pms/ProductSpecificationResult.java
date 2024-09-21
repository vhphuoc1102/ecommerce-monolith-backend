package com.phuocvh.app.dtos.pms;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductSpecificationResult {
  private Integer productId;
  private Map<String, String> specifications;
}
