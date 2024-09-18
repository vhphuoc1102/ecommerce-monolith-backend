package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmAttributeRepository
    extends JpaRepository<PmAttribute, Integer>, JpaSpecificationExecutor<PmAttribute> {}
