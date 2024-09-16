package com.phuocvh.app.controllers;

import com.phuocvh.app.services.OmCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class OmCartController {
  private final OmCartService omCartService;

  @PostMapping
  public void add(
      @RequestParam("productId") Integer productId,
      @RequestParam("productSkuId") Integer productSkuId,
      @RequestParam("quantity") Integer quantity) {
    omCartService.add(productId, productSkuId, quantity);
  }
}
