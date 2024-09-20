package com.phuocvh.app.dtos.pms;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class ProductOrSkuFlashSalePrice extends CommonPromoPrice {
  private LocalDateTime promoStartTs;
  private LocalDateTime promoEndTs;
  private Integer promoQuantity;
}
