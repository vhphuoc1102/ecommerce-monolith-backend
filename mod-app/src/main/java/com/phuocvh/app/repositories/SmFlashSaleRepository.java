package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.sms.SmFlashSale;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmFlashSaleRepository extends JpaRepository<SmFlashSale, Integer> {
  List<SmFlashSale> findByProductId(Integer productId);

  List<SmFlashSale> findByProductIdAndProductSkuId(Integer id, Integer productSkuId);
}
