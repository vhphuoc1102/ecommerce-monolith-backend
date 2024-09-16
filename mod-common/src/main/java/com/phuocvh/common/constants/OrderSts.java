package com.phuocvh.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderSts {
  PENDING_PAYMENT(0),
  PENDING_SHIPMENT(1),
  DELIVERED(2),
  COMPLETED(3),
  INVALID_ORDER(4);

  private final int value;
}
