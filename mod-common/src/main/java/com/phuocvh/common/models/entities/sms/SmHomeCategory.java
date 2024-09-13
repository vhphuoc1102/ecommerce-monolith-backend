package com.phuocvh.common.models.entities.sms;

import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SM_HOME_CATEGORY")
public class SmHomeCategory extends BaseAuditEntity {
  private Integer categoryId;

  private String categoryName;

  private String pic;

  private ShowSts showSts;

  private Integer sortOrder;

  private LocalDateTime startTs;

  private LocalDateTime endTs;
}
