package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmLadderPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmLadderPriceRepository
    extends JpaRepository<PmLadderPrice, Integer>, JpaSpecificationExecutor<PmLadderPrice> {}
