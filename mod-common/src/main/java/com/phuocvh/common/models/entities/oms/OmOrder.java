package com.phuocvh.common.models.entities.oms;

import com.phuocvh.common.constants.ConfirmSts;
import com.phuocvh.common.constants.DeleteSts;
import com.phuocvh.common.constants.OrderSts;
import com.phuocvh.common.constants.PayType;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "OM_ORDER")
public class OmOrder extends BaseAuditEntity {
  private Integer memberId;

  private String memberName;

  private Integer couponId;

  private String orderSn;

  private BigDecimal totalAmount;

  private BigDecimal payAmount;

  private BigDecimal freightAmount;

  private BigDecimal promoAmount;

  private BigDecimal giftAmount;

  private BigDecimal couponAmount;

  private BigDecimal discountAmount;

  private PayType payType;

  private OrderSts orderSts;

  private String freightCompany;

  private String freightSn;

  private LocalDateTime autoConfirmTs;

  private Integer giftPoint;

  private Integer levelPoint;

  private String billInvoice;

  private String billHeader;

  private String billRecipientPhone;

  private String billRecipientEmail;

  private String recipientName;

  private String recipientPhone;

  private String recipientProvince;

  private String recipientCity;

  private String recipientRegion;

  private String recipientAddress;

  private String note;

  private ConfirmSts confirmSts;

  private DeleteSts deleteSts;

  private Integer usedGiftPoint;

  private LocalDateTime deliveryTs;

  private LocalDateTime receiveTs;

  @OneToMany(mappedBy = "omOrder")
  private List<OmOrderItem> omOrderItems;

  @OneToMany(mappedBy = "omOrder")
  private List<OmOperateHistory> omOperateHistories;
}
