package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.NavSts;
import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_CATEGORY")
public class PmCategory extends BaseAuditEntity {
  private String name;

  private String icon;

  private String description;

  private String keywords;

  private Integer level;

  private Integer productQuantity;

  private NavSts navSts;

  private ShowSts showSts;

  @ManyToMany
  @JoinTable(
      name = "PM_CATEGORY_ATTRIBUTE",
      joinColumns = @JoinColumn(name = "CATEGORY_ID"),
      inverseJoinColumns = @JoinColumn(name = "ATTRIBUTE_ID"))
  private List<PmAttribute> pmAttribute;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PARENT_ID")
  private PmCategory parentPmCategory;

  @OneToMany(mappedBy = "parentPmCategory")
  private List<PmCategory> childrenPmCategory;
}
