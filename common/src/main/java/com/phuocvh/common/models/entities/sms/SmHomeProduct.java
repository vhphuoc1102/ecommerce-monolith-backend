package com.phuocvh.common.models.entities.sms;

import com.phuocvh.common.constants.ProductSubject;
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
@Table(name = "SM_HOME_PRODUCT")
public class SmHomeProduct extends BaseAuditEntity {
  private Integer productId;

  private Integer brandId;

  private Integer categoryId;

  private String pic;

  private String tags; // Comma separated string.

  private Integer sortOrder;

  private ProductSubject subject;

  private ShowSts showSts;

  private LocalDateTime startTs;

  private LocalDateTime endTs;
}
