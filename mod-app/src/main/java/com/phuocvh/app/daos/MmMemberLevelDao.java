package com.phuocvh.app.daos;

import com.phuocvh.app.repositories.MmMemberLevelRepository;
import com.phuocvh.common.exceptions.BusinessException;
import com.phuocvh.common.exceptions.BusinessExceptionReason;
import com.phuocvh.common.models.entities.mms.MmMemberLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MmMemberLevelDao {
  private final MmMemberLevelRepository mmMemberLevelRepository;

  public MmMemberLevel findById(Integer memberLevelId) {
    return mmMemberLevelRepository
        .findById(memberLevelId)
        .orElseThrow(
            () ->
                new BusinessException(
                    BusinessExceptionReason.ENTITY_NOT_FOUND,
                    MmMemberLevel.class.getSimpleName(),
                    memberLevelId));
  }
}
