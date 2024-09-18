package com.phuocvh.app.dtos.oms;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartItemResult {
  private String title;

  private String subtitle;

  private Integer quantity;

  private BigDecimal price;

  private Integer memberId;

  private Integer productId;

  private Integer productSkuId;

  private String productName;

  private String productPic;

  private String productSn;

  private String productSkuCode;

  private Map<String, Object> productAttribute;

  private String brandName;

  private Boolean isActive;
}
