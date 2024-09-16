package com.phuocvh.common.models.entities.oms;

import com.phuocvh.common.constants.ReturnSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "OM_ORDER_RETURN")
public class OmOrderReturn extends BaseAuditEntity {
  @ManyToOne
  @JoinColumn(name = "ORDER_ID", nullable = false)
  private OmOrder omOrder;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ITEM_ID")
  private OmOrderItem omOrderItem;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COMPANY_ADDRESS_ID")
  private OmCompanyAddress omCompanyAddress;

  private BigDecimal returnAmount;

  private String returnName;

  private String returnPhone;

  private ReturnSts returnSts;

  private String reason; // Choose from topics

  private String description; // Detail description

  private String pic; // Proof pics

  private String handlerNote;

  private Integer handlerId;

  private String handlerName;

  private LocalDateTime handleTs;

  private String recipientName;

  private Integer recipientId;

  private LocalDateTime receiveTs;

  private String recipientNote;
}
