package com.phuocvh.app.daos;

import com.phuocvh.app.repositories.UmMemberRepository;
import com.phuocvh.common.exceptions.BusinessException;
import com.phuocvh.common.exceptions.BusinessExceptionReason;
import com.phuocvh.common.models.entities.ums.UmMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UmMemberDao {
  private final UmMemberRepository umMemberRepository;

  public UmMember findById(Integer memberId){
    return umMemberRepository
        .findById(memberId)
        .orElseThrow(
            () -> new BusinessException(
                BusinessExceptionReason.ENTITY_NOT_FOUND,
                UmMember.class.getSimpleName(),
                memberId.toString()));
  }
}
