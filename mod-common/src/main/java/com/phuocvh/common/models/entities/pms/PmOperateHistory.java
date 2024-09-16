package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.*;
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
@Table(name = "PM_OPERATE_HISTORY")
public class PmOperateHistory extends BaseAuditEntity {
  private String name;

  private String title;

  private String subtitle;

  private String pic;

  private String productSn;

  private String description;

  private String keyword;

  private String note;

  private Integer stock;

  private Integer lowStock;

  private BigDecimal weight;

  private ActiveSts activeSts;

  private PublishSts publishSts;

  private NewSts newSts;

  private RecommendSts recommendSts;

  private VerifySts verifySts;

  private PreviewSts previewSts;

  private BigDecimal price;

  private BigDecimal originPrice;

  private BigDecimal promoPrice;

  private LocalDateTime promoStartTs;

  private LocalDateTime promoEndTs;

  private Integer promoPerLimit;

  private Integer promoType;

  private String detailTitle;

  private String detailDesc;

  private Integer sale;

  private Integer giftPoint;

  private Integer levelPoint;

  private Integer usePointLimit;

  private String operatorName;

  private String operatorNote;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID")
  private PmProduct pmProduct;
}
