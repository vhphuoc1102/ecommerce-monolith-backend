package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.oms.CartItemResult;
import com.phuocvh.app.dtos.oms.DeleteCartItemRequest;
import com.phuocvh.app.services.OmCartService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class OmCartController {
  private final OmCartService omCartService;

  @PostMapping("/{memberId}")
  public void add(
      @PathVariable("memberId") Integer memberId,
      @RequestParam("productId") Integer productId,
      @RequestParam("productSkuId") Integer productSkuId,
      @RequestParam(value = "quantity", required = false, defaultValue = "1") Integer quantity) {
    omCartService.add(memberId, productId, productSkuId, quantity);
  }

  @DeleteMapping("/{memberId}")
  public void remove(
      @PathVariable("memberId") Integer memberId,
      @Validated @RequestBody DeleteCartItemRequest request) {
    omCartService.remove(memberId, request);
  }

  @GetMapping("/{memberId}")
  public ResponseEntity<List<CartItemResult>> listAll(@PathVariable("memberId") Integer memberId) {
    return ResponseEntity.ok(omCartService.listAll(memberId));
  }

  @PutMapping("/{memberId}/quantity")
  public void updateQuantity(
      @PathVariable("memberId") Integer memberId,
      @RequestParam("productId") Integer productId,
      @RequestParam("productSkuId") Integer productSkuId,
      @RequestParam("isPosititive") Boolean isPositive) {
    omCartService.updateQuantity(memberId, productId, productSkuId, isPositive);
  }
}
