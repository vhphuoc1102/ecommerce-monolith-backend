package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
  private PmProduct pmProduct;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private PmAttribute pmAttribute;

  private String value;
}
