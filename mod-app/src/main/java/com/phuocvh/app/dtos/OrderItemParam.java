package com.phuocvh.app.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderItemParam {
  @NotNull private Integer productId;
  @NotNull private Integer productSkuId;
}
