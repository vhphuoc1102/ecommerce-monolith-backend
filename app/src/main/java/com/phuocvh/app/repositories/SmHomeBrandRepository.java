package com.phuocvh.app.repositories;

import com.phuocvh.app.repositories.projections.SmAndPmBrandProjection;
import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.sms.SmHomeBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SmHomeBrandRepository
    extends JpaRepository<SmHomeBrand, Integer>, JpaSpecificationExecutor<SmHomeBrand> {

  List<SmHomeBrand> findByShowStsEqualsOrderBySortOrderDesc(ShowSts showSts);

  @Query("""
      SELECT s as SmHomeBrand, p as PmBrand
      FROM SmHomeBrand s
      INNER JOIN PmBrand p
      ON s.brandId = p.id
      WHERE (s.showSts = 2)
      OR (s.showSts = 1 AND s.startTs <= CURRENT_TIMESTAMP AND s.endTs >= CURRENT_TIMESTAMP)
      ORDER BY s.sortOrder DESC
      """)
  List<SmAndPmBrandProjection> findHomeBrands();
}
