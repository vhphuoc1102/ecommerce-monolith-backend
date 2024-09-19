package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.sms.SmFlashSale;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmFlashSaleRepository extends JpaRepository<SmFlashSale, Integer> {
  Optional<SmFlashSale> findByProductId(Integer productId);
}
