package com.phuocvh.common.models.entities.mms;

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
@Table(name = "UM_MEMBER_LEVEL")
public class MmMemberLevel extends BaseEntity {
  private String name;

  private Integer levelPoint; // Minimum point to reach this level

  private Integer freightPoint; // Point to use for free shipping

  private Integer commentPoint; // Point received for a comment

  private Integer sortOrder;
}
