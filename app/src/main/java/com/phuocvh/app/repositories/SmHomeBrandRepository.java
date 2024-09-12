package com.phuocvh.app.repositories;

import com.phuocvh.app.repositories.projections.SmAndPmBrandProjection;
import com.phuocvh.common.models.entities.sms.SmHomeBrand;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface SmHomeBrandRepository
    extends JpaRepository<SmHomeBrand, Integer>, JpaSpecificationExecutor<SmHomeBrand> {

  @Query(
      value =
          """
            SELECT s as smHomeBrand, p as pmBrand
            FROM SmHomeBrand s
            INNER JOIN PmBrand p
            ON s.brandId = p.id
            WHERE (s.showSts = com.phuocvh.common.constants.ShowSts.ALWAYS_SHOW)
            OR (s.showSts = com.phuocvh.common.constants.ShowSts.SHOW
            AND s.startTs <= CURRENT_TIMESTAMP AND s.endTs >= CURRENT_TIMESTAMP)
            ORDER BY s.sortOrder DESC
          """)
  List<SmAndPmBrandProjection> findHomeBrands();
}
