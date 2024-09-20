package com.phuocvh.app.dtos.pms;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductSkuInfo {
  private ProductSkuGeneralInfo productSkuGeneralInfo;

  private ProductOrSkuFlashSalePrice flashSalePrice;
  private ProductOrSkuMemberPrice memberPrice;
  private List<ProductOrSkuLadderPrice> ladderPrices;
  private List<ProductOrSkuReducePrice> reducePrices;
}
