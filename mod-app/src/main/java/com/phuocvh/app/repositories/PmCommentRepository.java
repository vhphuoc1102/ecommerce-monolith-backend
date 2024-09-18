package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmCommentRepository
    extends JpaRepository<PmComment, Integer>, JpaSpecificationExecutor<PmComment> {}
