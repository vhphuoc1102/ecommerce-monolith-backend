package com.phuocvh.app.repositories;

import com.phuocvh.common.constants.AttributeType;
import com.phuocvh.common.models.entities.pms.PmProductAttribute;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PmProductAttributeRepository
    extends JpaRepository<PmProductAttribute, Integer>,
        JpaSpecificationExecutor<PmProductAttribute> {
  @Query(
      """
    SELECT ppa
    FROM PmProductAttribute ppa
    WHERE ppa.pmProduct.id = :productId
    AND ppa.pmAttribute.attributeType = :attributeType
""")
  List<PmProductAttribute> findByProductIdAndAttributeType(
      @Param("productId") Integer productId, @Param("attributeType") AttributeType attributeType);
}
