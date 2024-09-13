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
@Table(name = "PM_MEMBER_PRICE")
public class PmMemberPrice extends BaseAuditEntity {
  private Integer memberLevelId;

  private String memberLevelName;

  private BigDecimal memberPrice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID")
  private PmProduct pmProduct;
}
