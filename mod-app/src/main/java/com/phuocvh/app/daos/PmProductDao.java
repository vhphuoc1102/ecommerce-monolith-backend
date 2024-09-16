package com.phuocvh.app.daos;

import com.phuocvh.app.repositories.PmProductRepository;
import com.phuocvh.common.exceptions.BusinessException;
import com.phuocvh.common.exceptions.BusinessExceptionReason;
import com.phuocvh.common.models.entities.pms.PmProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PmProductDao {
  private final PmProductRepository pmProductRepository;

  public PmProduct findById(Integer productId) {
    return pmProductRepository
        .findById(productId)
        .orElseThrow(
            () ->
                new BusinessException(
                    BusinessExceptionReason.ENTITY_NOT_FOUND,
                    PmProduct.class.getSimpleName(),
                    productId));
  }
}
