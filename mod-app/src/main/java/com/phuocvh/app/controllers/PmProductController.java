package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.pms.ProductDetailResult;
import com.phuocvh.app.dtos.pms.ProductSpecificationResult;
import com.phuocvh.app.services.PmProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class PmProductController {
  private final PmProductService pmProductService;

  @GetMapping("/{memberId}/{productId}")
  public ResponseEntity<ProductDetailResult> getProductDetail(
      @PathVariable("memberId") Integer memberId, @PathVariable("productId") Integer productId) {
    return ResponseEntity.ok(pmProductService.getProductDetail(memberId, productId));
  }

  @GetMapping("/{productId}/specifications")
  public ResponseEntity<ProductSpecificationResult> getProductSpecifications(
      @PathVariable("productId") Integer productId) {
    return ResponseEntity.ok(pmProductService.getProductSpecifications(productId));
  }
}
