package com.phuocvh.app.services;

import com.phuocvh.app.daos.PmProductDao;
import com.phuocvh.app.daos.PmSkuDao;
import com.phuocvh.common.models.entities.pms.PmProduct;
import com.phuocvh.common.models.entities.pms.PmSku;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OmCartService {
  private final PmProductDao pmProductDao;
  private final PmSkuDao pmSkuDao;

  @Transactional(rollbackFor = Exception.class)
  public void add(Integer productId, Integer productSkuId, Integer quantity) {
    PmProduct pmProduct = pmProductDao.findById(productId);
    PmSku pmSku = pmSkuDao.findByIdAndProductId(productSkuId, productId);
  }
}
