package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmCommentReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmCommentReplyRepository
    extends JpaRepository<PmCommentReply, Integer>, JpaSpecificationExecutor<PmCommentReply> {}
