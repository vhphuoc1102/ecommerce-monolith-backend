package com.phuocvh.common.models.entities.mms;

import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MM_PRODUCT_SUBJECT")
public class MmProductSubject extends BaseEntity {
  private Integer type; // TODO: 1: carousel, 2: banner, 3: list
  private ShowSts showSts;
  private Integer sortOrder;
}
