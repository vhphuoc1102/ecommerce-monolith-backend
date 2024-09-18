package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmReducePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmReducePriceRepository
    extends JpaRepository<PmReducePrice, Integer>, JpaSpecificationExecutor<PmReducePrice> {}
