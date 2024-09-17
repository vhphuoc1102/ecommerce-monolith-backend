package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.ums.UmMember;
import com.phuocvh.common.models.entities.ums.UmMemberCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UmMemberRepository extends JpaRepository<UmMember, Integer> ,
    JpaSpecificationExecutor<UmMemberCredential> {
}