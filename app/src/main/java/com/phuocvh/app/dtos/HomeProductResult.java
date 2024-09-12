package com.phuocvh.app.dtos;

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

  private Integer brandId;

  private Integer categoryId;

  private String productName;

  private String title;

  private String subtitle;

  private Integer reviews;

  private BigDecimal ratings;

  private Integer stock;

  private Integer sale;

  private BigDecimal price;

  private BigDecimal promoPrice;

  private String pic;

  private List<String> tags; // Comma separated string.
}
