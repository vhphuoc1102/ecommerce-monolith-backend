package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.HomeBrandResult;
import com.phuocvh.app.dtos.HomeCategoryResult;
import com.phuocvh.app.dtos.HomeProductResult;
import com.phuocvh.app.dtos.ProductSubjectResult;
import com.phuocvh.app.services.SmHomeService;
import com.phuocvh.common.models.dtos.FilterParams;
import com.phuocvh.common.models.dtos.PaginationResult;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class SmHomeController {
  private final SmHomeService smHomeService;

  @GetMapping("/brands")
  public List<HomeBrandResult> findHomeBrands() {
    return smHomeService.findHomeBrands();
  }

  @GetMapping("/categories")
  public List<HomeCategoryResult> findHomeCategories() {
    return smHomeService.findHomeCategories();
  }

  @GetMapping("/subjects")
  public ResponseEntity<List<ProductSubjectResult>> findProductSubjects() {
    return ResponseEntity.ok(smHomeService.findProductSubjects());
  }

  @GetMapping("/products")
  public ResponseEntity<PaginationResult<HomeProductResult>> findHomeProducts(
      @RequestParam("productSubjectId") Integer productSubjectId, FilterParams filterParams) {
    return ResponseEntity.ok(smHomeService.findHomeProducts(productSubjectId, filterParams));
  }
}
