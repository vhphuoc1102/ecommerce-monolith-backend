package com.phuocvh.common.models.entities.sms;

import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SM_HOME_PRODUCT")
public class SmHomeProduct extends BaseAuditEntity {
  private Integer productId;

  private String productName;

  private String title;

  private String subtitle;

  private Integer review;

  private BigDecimal rating;

  private Integer stock;

  private Integer sale;

  private BigDecimal price;

  private BigDecimal promoPrice;

  private String pic;

  private String tags; // TODO: Comma separated string.

  private ShowSts showSts;

  private LocalDateTime startTs;

  private LocalDateTime endTs;

  private Integer sortOrder;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "PRODUCT_SUBJECT_ID")
  private SmProductSubject smProductSubject;
}
