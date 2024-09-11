package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_REDUCE_PRICE")
public class PmReducePrice extends BaseAuditEntity {
  private BigDecimal fullPrice;

  private BigDecimal reducePrice;

  @ManyToOne(fetch = FetchType.LAZY)
  private PmProduct pmProduct;
}
