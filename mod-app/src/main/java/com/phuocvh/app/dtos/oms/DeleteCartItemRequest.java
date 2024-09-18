package com.phuocvh.app.dtos.oms;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

@Getter
@Setter
@Builder
public class DeleteCartItemRequest {
  // <ProductID, ProductSkuID, isAll>
  @NotEmpty private List<Pair<Integer, Integer>> deleteItems;
}
