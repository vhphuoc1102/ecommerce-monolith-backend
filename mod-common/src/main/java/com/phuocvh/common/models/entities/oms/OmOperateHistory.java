package com.phuocvh.common.models.entities.oms;

import com.phuocvh.common.constants.OrderSts;
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
@Table(name = "OM_OPERATE_HISTORY")
public class OmOperateHistory extends BaseAuditEntity {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ID")
  private OmOrder omOrder;

  private String orderSn;

  private String title;

  private String subtitle;

  private Integer quantity;

  private BigDecimal price;

  private BigDecimal realPrice;

  private Integer productId;

  private Integer productSkuId;

  private String productName;

  private String productPic;

  private String productSn;

  private String productSkuCode;

  private OrderSts orderSts;

  private String operatorName;

  private String operatorNote;
}
