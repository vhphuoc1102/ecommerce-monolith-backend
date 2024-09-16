package com.phuocvh.app.daos;

import com.phuocvh.app.repositories.PmSkuRepository;
import com.phuocvh.common.exceptions.BusinessException;
import com.phuocvh.common.exceptions.BusinessExceptionReason;
import com.phuocvh.common.models.entities.pms.PmProduct;
import com.phuocvh.common.models.entities.pms.PmSku;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PmSkuDao {
  private final PmSkuRepository pmSkuRepository;

  public PmSku findByIdAndProductId(Integer productSkuId, Integer productId) {
    return pmSkuRepository
        .findByIdAndProductId(productSkuId, productId)
        .orElseThrow(
            () ->
                new BusinessException(
                    BusinessExceptionReason.ENTITY_NOT_FOUND,
                    PmSku.class.getSimpleName(),
                    Arrays.asList(
                            Pair.of(PmSku.class, productSkuId), Pair.of(PmProduct.class, productId))
                        .toString()));
  }
}
