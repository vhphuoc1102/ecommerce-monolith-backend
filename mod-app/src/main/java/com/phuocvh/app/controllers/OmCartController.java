package com.phuocvh.app.controllers;

import com.phuocvh.app.services.OmCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
  public void remove(@PathVariable("memberId") Integer memberId,
                     @RequestParam("productIds") List<Integer> productIds,
                     @RequestParam("productSkuId") List<Integer> productSkuId) {
    omCartService.remove(memberId, productId, productSkuId);
  }
}
