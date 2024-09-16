package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.oms.OmCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OmCartItemRepository
    extends JpaRepository<OmCartItem, Integer>, JpaSpecificationExecutor<OmCartItem> {}
