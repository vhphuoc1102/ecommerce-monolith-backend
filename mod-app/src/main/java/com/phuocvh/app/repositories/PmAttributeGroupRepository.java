package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmAttributeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmAttributeGroupRepository
    extends JpaRepository<PmAttributeGroup, Integer>, JpaSpecificationExecutor<PmAttributeGroup> {}
