package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.sms.SmHomeProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SmHomeProductRepository
    extends JpaRepository<SmHomeProduct, Integer>, JpaSpecificationExecutor<SmHomeProduct> {

  @Query(
      value =
          """
             SELECT sm.*
             FROM sm_home_product sm
             WHERE sm.product_subject_id = :productSubjectId
             ORDER BY sm.sort_order DESC
          """,
      countQuery =
          """
            SELECT COUNT(*)
            FROM sm_home_product sm
            WHERE sm.product_subject_id = :productSubjectId
          """,
      nativeQuery = true)
  Page<SmHomeProduct> findHomeProducts(
      @Param("productSubjectId") Integer productSubjectId, Pageable pageable);
}
