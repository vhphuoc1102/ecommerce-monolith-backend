package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmProductRepository
    extends JpaRepository<PmProduct, Integer>, JpaSpecificationExecutor<PmProduct> {}
