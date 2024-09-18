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
  private Integer memberId = -1;

  private String memberName = "";

  private Integer couponId = -1;

  private String orderSn = "";

  private BigDecimal totalAmount = BigDecimal.ZERO;

  private BigDecimal payAmount = BigDecimal.ZERO;

  private BigDecimal freightAmount = BigDecimal.ZERO;

  private BigDecimal promoAmount = BigDecimal.ZERO;

  private BigDecimal giftAmount = BigDecimal.ZERO;

  private BigDecimal couponAmount = BigDecimal.ZERO;

  private BigDecimal discountAmount = BigDecimal.ZERO;

  private PayType payType = PayType.NOT_PAID;

  private OrderSts orderSts = OrderSts.PENDING_PAYMENT;

  private String freightCompany = "";

  private String freightSn = "";

  private LocalDateTime autoConfirmTs;

  private Integer giftPoint = 0;

  private Integer levelPoint = 0;

  private String billInvoice = "";

  private String billHeader = "";

  private String billRecipientPhone = "";

  private String billRecipientEmail = "";

  private String recipientName = "";

  private String recipientPhone = "";

  private String recipientProvince = "";

  private String recipientCity = "";

  private String recipientRegion = "";

  private String recipientAddress = "";

  private String note = "";

  private ConfirmSts confirmSts = ConfirmSts.NOT_CONFIRM;

  private DeleteSts deleteSts = DeleteSts.NOT_DELETED;

  private Integer usedGiftPoint = 0;

  private LocalDateTime deliveryTs;

  private LocalDateTime receiveTs;

  @OneToMany(mappedBy = "omOrder")
  private List<OmOrderItem> omOrderItems;

  @OneToMany(mappedBy = "omOrder")
  private List<OmOperateHistory> omOperateHistories;
}
