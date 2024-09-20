package com.phuocvh.app.dtos.pms;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductSkuGeneralInfo {
  private Integer productSkuId;

  private String name;

  private String pic;

  private Integer stock;

  private Integer lowStock;

  @Builder.Default private Map<String, Object> attribute = new HashMap<>();

  private BigDecimal price;

  private List<String> productSkuPics;
}
