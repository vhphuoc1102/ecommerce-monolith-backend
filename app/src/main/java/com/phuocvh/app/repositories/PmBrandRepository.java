package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmBrand;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmBrandRepository
    extends JpaRepository<PmBrand, Integer>, JpaSpecificationExecutor<PmBrand> {
  List<PmBrand> findByIdIn(List<Integer> ids);
}
