package com.phuocvh.app.repositories;

import com.phuocvh.common.constants.ProductSubject;
import com.phuocvh.common.models.entities.sms.SmHomeProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SmHomeProductRepository
    extends JpaRepository<SmHomeProduct, Integer>, JpaSpecificationExecutor<SmHomeProduct> {
  List<SmHomeProduct> findBySubjectOrderBySortOrderDesc(ProductSubject subject, Pageable pageable);

  Long countBySubject(ProductSubject subject);
}
