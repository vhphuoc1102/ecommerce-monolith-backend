package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.pms.ProductCommentResult;
import com.phuocvh.app.dtos.pms.ProductCommentStatisticsResult;
import com.phuocvh.app.services.PmCommentService;
import com.phuocvh.common.models.dtos.FilterParams;
import com.phuocvh.common.models.dtos.PaginationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class PmCommentController {
  private final PmCommentService pmCommentService;

  @GetMapping("/{productId}/product")
  public ResponseEntity<PaginationResult<ProductCommentResult>> getProductComments(
      @PathVariable("productId") Integer productId, FilterParams filterParams) {
    return ResponseEntity.ok(pmCommentService.getProductComments(productId, filterParams));
  }

  @GetMapping("/{productId}/product/statistics")
  public ResponseEntity<ProductCommentStatisticsResult> getProductCommentStatistics(
      @PathVariable("productId") Integer productId) {
    return ResponseEntity.ok(pmCommentService.getProductCommentStatistics(productId));
  }
}
