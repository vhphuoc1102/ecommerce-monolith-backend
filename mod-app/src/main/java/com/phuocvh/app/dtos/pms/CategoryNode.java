package com.phuocvh.app.dtos.pms;

import com.phuocvh.common.models.entities.pms.PmCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CategoryNode {
  private Integer categoryId;
  private String categoryName;
  private String icon;

  @Builder.Default List<CategoryNode> children = new ArrayList<>();

  public CategoryNode(PmCategory pmCategory) {
    this.categoryId = pmCategory.getId();
    this.categoryName = pmCategory.getName();
    this.icon = pmCategory.getIcon();
    this.children = mapChildren(pmCategory.getChildrenPmCategory());
  }

  private List<CategoryNode> mapChildren(List<PmCategory> childrenPmCategory) {
    if (CollectionUtils.isEmpty(childrenPmCategory)) {
      return new ArrayList<>();
    }
    return childrenPmCategory.stream().map(CategoryNode::new).collect(Collectors.toList());
  }
}
