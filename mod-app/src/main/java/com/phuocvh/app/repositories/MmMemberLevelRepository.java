package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.mms.MmMemberLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MmMemberLevelRepository extends JpaRepository<MmMemberLevel, Integer>, JpaSpecificationExecutor<MmMemberLevel> {
}