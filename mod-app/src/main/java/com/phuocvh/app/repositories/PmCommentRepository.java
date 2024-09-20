package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PmCommentRepository
    extends JpaRepository<PmComment, Integer>, JpaSpecificationExecutor<PmComment> {
  @Query(
      value = """
          SELECT c.*
          FROM pm_comment c
          WHERE c.product_id = :productId
          ORDER BY c.created_at DESC
    """,
      countQuery = """
          SELECT COUNT(*)
          FROM pm_comment c
          WHERE c.product_id = :productId
    """,
      nativeQuery = true
  )
  Page<PmComment> findByProductId(@Param("productId") Integer productId, Pageable pageable);

  @Query(
      """
SELECT c
FROM PmComment c
WHERE c.pmProduct.id = :productId
"""
  )
  List<PmComment> findByProductId(@Param("productId") Integer productId);
}
