package com.phuocvh.app.dtos;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderDraftItemResult {
  private String title;

  private String subtitle;

  private Integer quantity;

  private BigDecimal price;

  private Integer productId;

  private Integer productSkuId;

  private String productName;

  private String productPic;

  private String productSn;

  private String productSkuCode;

  private Map<String, Object> productAttribute;

  private String brandName;
}
