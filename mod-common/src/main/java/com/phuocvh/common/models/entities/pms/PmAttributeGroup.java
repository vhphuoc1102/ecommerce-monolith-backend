package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_ATTRIBUTE_GROUP")
public class PmAttributeGroup extends BaseAuditEntity {
  private String name;
  private Integer paramQuantity;
  private Integer attributeQuantity;
}
