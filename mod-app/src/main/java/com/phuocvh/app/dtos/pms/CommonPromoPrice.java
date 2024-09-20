package com.phuocvh.app.dtos.pms;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public abstract class CommonPromoPrice {
  protected BigDecimal promoPrice;
}
