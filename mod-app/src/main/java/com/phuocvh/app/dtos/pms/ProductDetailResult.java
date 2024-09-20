package com.phuocvh.app.dtos.pms;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDetailResult {
  private ProductInfo productInfo;
  private Map<Integer, ProductSkuInfo> productSkuInfos;
}
