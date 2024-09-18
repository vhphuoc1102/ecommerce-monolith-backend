package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmMemberPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmMemberPriceRepository
    extends JpaRepository<PmMemberPrice, Integer>, JpaSpecificationExecutor<PmMemberPrice> {}
