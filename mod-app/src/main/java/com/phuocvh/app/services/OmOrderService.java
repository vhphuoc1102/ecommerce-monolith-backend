package com.phuocvh.app.services;

import com.phuocvh.app.daos.PmProductDao;
import com.phuocvh.app.daos.PmSkuDao;
import com.phuocvh.app.daos.UmMemberDao;
import com.phuocvh.app.dtos.oms.OrderItemParam;
import com.phuocvh.app.repositories.OmOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OmOrderService {
  private final OmOrderRepository omOrderRepository;
  private final UmMemberDao umMemberDao;
  private final PmProductDao pmProductDao;
  private final PmSkuDao pmSkuDao;

  @Transactional(rollbackFor = Exception.class)
  public void add(Integer memberId, OrderItemParam orderItemParam) {
    umMemberDao.findById(memberId);
  }
}
