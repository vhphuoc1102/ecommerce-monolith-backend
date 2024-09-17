package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.oms.OmCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface OmCartItemRepository
    extends JpaRepository<OmCartItem, Integer>, JpaSpecificationExecutor<OmCartItem> {
  Optional<OmCartItem> findByMemberIdAndProductIdAndProductSkuId(Integer memberId, Integer productId, Integer productSkuId);
}
