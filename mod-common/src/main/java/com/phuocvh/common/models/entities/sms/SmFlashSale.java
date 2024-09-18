package com.phuocvh.common.models.entities.sms;

import com.phuocvh.common.constants.ActiveSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SM_FLASH_SALE")
public class SmFlashSale extends BaseAuditEntity {
  private Integer productId;

  private Integer productSkuId;

  private BigDecimal price;

  private LocalDateTime startTs;

  private LocalDateTime endTs;

  private ActiveSts activeSts;

  private Integer quantity;
}
