package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.ActiveSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
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

  private ActiveSts activeSts;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID")
  private PmProduct pmProduct;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SKU_ID")
  private PmSku pmSku;
}
