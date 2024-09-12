package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PmCategoryRepository
    extends JpaRepository<PmCategory, Integer>, JpaSpecificationExecutor<PmCategory> {
  List<PmCategory> findByIdIn(List<Integer> categoryIds);

  @Query(
      value =
          """
            SELECT c
            FROM PmCategory c
            WHERE c.parentPmCategory IS NULL
          """)
  List<PmCategory> findTree();
}
