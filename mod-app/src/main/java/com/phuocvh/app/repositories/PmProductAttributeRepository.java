package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmProductAttributeRepository
    extends JpaRepository<PmProductAttribute, Integer>,
        JpaSpecificationExecutor<PmProductAttribute> {}
