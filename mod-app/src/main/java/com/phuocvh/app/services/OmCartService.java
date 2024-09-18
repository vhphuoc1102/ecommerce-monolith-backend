package com.phuocvh.app.services;

import com.phuocvh.app.daos.PmProductDao;
import com.phuocvh.app.daos.PmSkuDao;
import com.phuocvh.app.daos.UmMemberDao;
import com.phuocvh.app.dtos.CartItemResult;
import com.phuocvh.app.dtos.DeleteCartItemRequest;
import com.phuocvh.app.mappers.OmCartItemMapper;
import com.phuocvh.app.repositories.OmCartItemRepository;
import com.phuocvh.common.constants.ActiveSts;
import com.phuocvh.common.models.entities.oms.OmCartItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    Optional<OmCartItem> cartItemOptional =
        omCartItemRepository.findByMemberIdAndProductIdAndProductSkuId(
            memberId, productId, productSkuId);
    OmCartItem cartItem;
    if (cartItemOptional.isPresent()) {
      cartItem = cartItemOptional.get();
      cartItem.setQuantity(cartItem.getQuantity() + quantity);
    } else {
      cartItem = new OmCartItem();
      cartItem.setMemberId(memberId);
      cartItem.setProductId(productId);
      cartItem.setProductSkuId(productSkuId);
      cartItem.setQuantity(quantity);
      cartItem.setActiveSts(ActiveSts.INACTIVE);
    }
    omCartItemRepository.save(cartItem);
  }

  @Transactional(rollbackFor = Exception.class)
  public void remove(Integer memberId, DeleteCartItemRequest request) {
    umMemberDao.findById(memberId);
    List<Pair<Integer, Integer>> deleteItems = request.getDeleteItems();
    List<OmCartItem> itemsToDelete = new ArrayList<>();
    deleteItems.forEach(
        item -> {
          Integer productId = item.getLeft();
          Integer productSkuId = item.getRight();
          pmProductDao.findById(productId);
          pmSkuDao.findByIdAndProductId(productSkuId, productId);
          Optional<OmCartItem> cartItemOptional =
              omCartItemRepository.findByMemberIdAndProductIdAndProductSkuId(
                  memberId, productId, productSkuId);
          if (cartItemOptional.isEmpty()) {
            return;
          }
          OmCartItem omCartItem = cartItemOptional.get();
          itemsToDelete.add(omCartItem);
        });
    if (CollectionUtils.isEmpty(itemsToDelete)) omCartItemRepository.saveAll(itemsToDelete);
  }

  public List<CartItemResult> listAll(Integer memberId) {
    return omCartItemRepository.findAllByMemberId(memberId).stream()
        .map(OmCartItemMapper.MAPPER::toResult)
        .toList();
  }

  @Transactional(rollbackFor = Exception.class)
  public void updateQuantity(
      Integer memberId, Integer productId, Integer productSkuId, Boolean isPositive) {
    umMemberDao.findById(memberId);
    pmProductDao.findById(productId);
    pmSkuDao.findByIdAndProductId(productSkuId, productId);
    omCartItemRepository
        .findByMemberIdAndProductIdAndProductSkuId(memberId, productId, productSkuId)
        .ifPresent(
            cartItem -> {
              Integer quantity = cartItem.getQuantity();
              if (quantity == 1 && !isPositive) {
                omCartItemRepository.delete(cartItem);
                return;
              } else if (isPositive) {
                quantity++;
              } else {
                quantity--;
              }
              cartItem.setQuantity(quantity);
              omCartItemRepository.save(cartItem);
            });
  }
}
