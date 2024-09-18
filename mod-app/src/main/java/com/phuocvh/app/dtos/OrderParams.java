package com.phuocvh.app.dtos;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderParams {
  private List<OrderItemParam> params;
}
