package com.phuocvh.app.repositories;

import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.sms.SmHomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SmHomeCategoryRepository
    extends JpaRepository<SmHomeCategory, Integer>, JpaSpecificationExecutor<SmHomeCategory> {
  List<SmHomeCategory> findByShowStsEqualsOrderBySortOrderDesc(ShowSts showSts);
}
