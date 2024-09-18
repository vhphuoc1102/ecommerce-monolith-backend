package com.phuocvh.app.dtos.sms;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HomeProductResult {
  private Integer productId;

  private String productName;

  private String title;

  private String subtitle;

  private Integer review;

  private BigDecimal rating;

  private Integer stock;

  private Integer sale;

  private BigDecimal price;

  private BigDecimal promoPrice;

  private String pic;

  private List<String> tags; // Comma separated string.
}
