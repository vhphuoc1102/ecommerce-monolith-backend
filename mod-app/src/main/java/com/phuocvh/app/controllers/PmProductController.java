package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.pms.ProductDetailResult;
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

  @GetMapping("/{productId}")
  private ResponseEntity<ProductDetailResult> get(@PathVariable("productId") Integer productId) {
    return ResponseEntity.ok(pmProductService.get(productId));
  }
}
