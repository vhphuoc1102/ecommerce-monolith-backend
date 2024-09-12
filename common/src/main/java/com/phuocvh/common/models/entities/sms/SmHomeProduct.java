package com.phuocvh.common.models.entities.sms;

import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SM_HOME_PRODUCT")
public class SmHomeProduct extends BaseAuditEntity {
  private Integer productId;

  private String pic;

  private String tags; // TODO: Comma separated string.

  private ShowSts showSts;

  private LocalDateTime startTs;

  private LocalDateTime endTs;

  private Integer sortOrder;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private SmProductSubject smProductSubject;
}
