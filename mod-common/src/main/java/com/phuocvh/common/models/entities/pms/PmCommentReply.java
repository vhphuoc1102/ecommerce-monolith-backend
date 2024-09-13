package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
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
  @JoinColumn(name = "COMMENT_ID")
  private PmComment pmComment;
}
