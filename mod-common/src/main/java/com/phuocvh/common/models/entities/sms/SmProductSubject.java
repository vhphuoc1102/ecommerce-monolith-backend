package com.phuocvh.common.models.entities.sms;

import com.phuocvh.common.constants.ProductSubjectType;
import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SM_HOME_PRODUCT")
public class SmProductSubject extends BaseAuditEntity {
  private ProductSubjectType subjectType;

  private Integer subjectId;

  private ShowSts showSts;

  private Integer sortOrder;

  @OneToMany(mappedBy = "smProductSubject", orphanRemoval = true)
  private List<SmHomeProduct> smHomeProducts;

  private LocalDateTime startTs;

  private LocalDateTime endTs;
}
