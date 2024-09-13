package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_PRODUCT_ATTRIBUTE")
public class PmProductAttribute extends BaseAuditEntity {
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "PRODUCT_ID")
  private PmProduct pmProduct;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "ATTRIBUTE_ID")
  private PmAttribute pmAttribute;

  private String value;
}
