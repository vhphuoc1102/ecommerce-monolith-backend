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
@Table(name = "PM_MEMBER_PRICE")
public class PmMemberPrice extends BaseAuditEntity {
  private Integer memberLevelId;

  private String memberLevelName;

  private BigDecimal memberPrice;

  @ManyToOne(fetch = FetchType.LAZY)
  private PmProduct pmProduct;
}
