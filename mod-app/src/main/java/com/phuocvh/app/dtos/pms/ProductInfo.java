package com.phuocvh.app.dtos.pms;

import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
  private ProductGeneralInfo productGeneralInfo;

  private ProductOrSkuFlashSalePrice flashSalePrice;

  private ProductOrSkuMemberPrice memberPrice;

  private List<ProductOrSkuLadderPrice> ladderPrices;

  private List<ProductOrSkuReducePrice> reducePrices;
}
