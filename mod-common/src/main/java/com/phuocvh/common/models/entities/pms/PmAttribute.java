package com.phuocvh.common.models.entities.pms;

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
@Table(name = "PM_ATTRIBUTE")
public class PmAttribute extends BaseAuditEntity {
  private String name;

  private Integer selectType;

  private Integer inputType;

  private String inputData;

  private Integer filterType;

  private Integer searchType;

  private Integer relatedSts;

  private Integer handAddSts;

  private Integer type;

  @ManyToMany(mappedBy = "pmAttribute")
  private List<PmCategory> pmCategory;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ATTRIBUTE_GROUP_ID")
  private PmAttributeGroup pmAttributeGroup;
}
