package com.phuocvh.app.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

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
