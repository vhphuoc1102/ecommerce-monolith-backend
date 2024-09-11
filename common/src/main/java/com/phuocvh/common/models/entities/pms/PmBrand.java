package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_BRAND")
public class PmBrand extends BaseAuditEntity {
  private String name;
  private String firstLetter;
  private Integer productQuantity;
  private Integer productCommentQuantity;
  private ShowSts showSts;
  private String logo;
  private String bigPic;
  private String brandStory;
}
