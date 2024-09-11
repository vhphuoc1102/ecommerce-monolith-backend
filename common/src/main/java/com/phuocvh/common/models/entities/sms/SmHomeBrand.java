package com.phuocvh.common.models.entities.sms;

import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SM_HOME_BRAND")
public class SmHomeBrand extends BaseAuditEntity {
  private Integer brandId;

  private String pic;

  private ShowSts showSts;

  private Integer sortOrder;

  private LocalDateTime startTs;

  private LocalDateTime endTs;
}
