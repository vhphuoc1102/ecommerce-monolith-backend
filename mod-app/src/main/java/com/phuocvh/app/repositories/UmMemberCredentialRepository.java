package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.ums.UmMemberCredential;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UmMemberCredentialRepository
    extends JpaRepository<UmMemberCredential, Integer>,
        JpaSpecificationExecutor<UmMemberCredential> {
  Optional<UmMemberCredential> findByEmail(String email);

  Optional<UmMemberCredential> findByPhone(String phone);
}
