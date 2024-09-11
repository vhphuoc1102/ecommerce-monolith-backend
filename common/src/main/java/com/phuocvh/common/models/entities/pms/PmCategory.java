package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.NavSts;
import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
  private List<PmAttribute> pmAttribute;

  @ManyToOne(fetch = FetchType.LAZY)
  private PmCategory parentPmCategory;
}
