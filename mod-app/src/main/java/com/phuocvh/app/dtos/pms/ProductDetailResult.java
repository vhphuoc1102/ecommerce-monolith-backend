package com.phuocvh.app.dtos.pms;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDetailResult {
  private ProductInfo productInfo;
  private List<ProductSkuInfo> productSkuInfos;
}
