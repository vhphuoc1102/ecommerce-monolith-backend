package com.phuocvh.app.controllers;

import com.phuocvh.app.dtos.CategoryNode;
import com.phuocvh.app.services.PmCategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class PmCategoryController {
  private final PmCategoryService pmCategoryService;

  @GetMapping("/tree")
  public List<CategoryNode> findTree() {
    return pmCategoryService.findTree();
  }
}
