package com.phuocvh.app.services;

import com.phuocvh.app.daos.PmProductDao;
import com.phuocvh.app.daos.PmSkuDao;
import com.phuocvh.app.daos.UmMemberDao;
import com.phuocvh.app.repositories.OmCartItemRepository;
import com.phuocvh.common.models.entities.oms.OmCartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OmCartService {
  private final PmProductDao pmProductDao;
  private final PmSkuDao pmSkuDao;
  private final UmMemberDao umMemberDao;
  private final OmCartItemRepository omCartItemRepository;

  @Transactional(rollbackFor = Exception.class)
  public void add(Integer memberId, Integer productId, Integer productSkuId, Integer quantity) {
    umMemberDao.findById(memberId);
    pmProductDao.findById(productId);
    pmSkuDao.findByIdAndProductId(productSkuId, productId);
    Optional<OmCartItem> cartItemOptional = omCartItemRepository.findByMemberIdAndProductIdAndProductSkuId(memberId, productId, productSkuId);
    OmCartItem cartItem;
    if(cartItemOptional.isPresent()){
      cartItem = cartItemOptional.get();
      cartItem.setQuantity(cartItem.getQuantity() + quantity);
    } else {
      cartItem = new OmCartItem();
      cartItem.setMemberId(memberId);
      cartItem.setProductId(productId);
      cartItem.setProductSkuId(productSkuId);
      cartItem.setQuantity(quantity);
    }
    omCartItemRepository.save(cartItem);
  }
}
