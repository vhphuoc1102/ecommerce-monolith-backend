package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PmCategoryRepository
    extends JpaRepository<PmCategory, Integer>, JpaSpecificationExecutor<PmCategory> {
  List<PmCategory> findByIdIn(List<Integer> categoryIds);
}
