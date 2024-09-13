package com.phuocvh.common.models.entities.pms;

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
@Table(name = "PM_LADDER_PRICE")
public class PmLadderPrice extends BaseAuditEntity {
  private Integer quantity;

  private BigDecimal discount;

  private BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID")
  private PmProduct pmProduct;
}
