package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.OrderItemParam;
import com.phuocvh.app.services.OmOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OmOrderController {
  private final OmOrderService omOrderService;

  public ResponseEntity

  @PostMapping("/{memberId}")
  public void add(
      @PathVariable("memberId") Integer memberId,
      @Validated @RequestBody OrderItemParam orderItemParam) {
    omOrderService.add(memberId, orderItemParam);
  }
}
