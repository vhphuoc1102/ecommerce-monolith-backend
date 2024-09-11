package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_COMMENT_REPLY")
public class PmCommentReply extends BaseAuditEntity {
  private String memberUsername;

  private String memberIcon;

  private String content;

  private Integer type;

  @ManyToOne(fetch = FetchType.LAZY)
  private PmComment pmComment;
}
