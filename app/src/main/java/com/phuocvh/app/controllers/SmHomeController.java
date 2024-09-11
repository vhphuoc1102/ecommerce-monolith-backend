package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.HomeBrandResult;
import com.phuocvh.app.dtos.HomeCategoryResult;
import com.phuocvh.app.dtos.HomeProductResult;
import com.phuocvh.app.services.HomeService;
import com.phuocvh.common.constants.ProductSubject;
import com.phuocvh.common.models.dtos.FilterParams;
import com.phuocvh.common.models.dtos.PaginationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class SmHomeController {
  private final HomeService homeService;

  @GetMapping("/brand")
  public List<HomeBrandResult> findHomeBrands() {
    return homeService.findHomeBrand();
  }

  @GetMapping("/category")
  public List<HomeCategoryResult> findHomeCategories() {
    return homeService.findHomeCategories();
  }

  @GetMapping("/product")
  public PaginationResult<HomeProductResult> findHomeProducts(
      @RequestParam("subject") ProductSubject subject, FilterParams filterParam) {
    return homeService.findHomeProducts(subject, filterParam);
  }
}
