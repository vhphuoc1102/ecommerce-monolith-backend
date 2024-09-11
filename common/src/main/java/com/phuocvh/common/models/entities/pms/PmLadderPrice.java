package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_LADDER_PRICE")
public class PmLadderPrice extends BaseAuditEntity {
  private Integer quantity;

  private BigDecimal discount;

  private BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY)
  private PmProduct pmProduct;
}
