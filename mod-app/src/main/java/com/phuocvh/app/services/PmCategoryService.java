package com.phuocvh.app.services;

import com.phuocvh.app.dtos.CategoryNode;
import com.phuocvh.app.repositories.PmCategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PmCategoryService {
  private final PmCategoryRepository pmCategoryRepository;

  public List<CategoryNode> findTree() {
    return pmCategoryRepository.findTree().stream().map(CategoryNode::new).toList();
  }
}
