package com.phuocvh.app.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

@Getter
@Setter
@Builder
public class DeleteCartItemRequest {
  // <ProductID, ProductSkuID, IsAll>
  private List<Triple<Integer, Integer, Boolean>> deleteObjects;
}
