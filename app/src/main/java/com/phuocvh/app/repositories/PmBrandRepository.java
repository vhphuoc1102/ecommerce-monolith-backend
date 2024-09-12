package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmBrandRepository
    extends JpaRepository<PmBrand, Integer>, JpaSpecificationExecutor<PmBrand> {}
