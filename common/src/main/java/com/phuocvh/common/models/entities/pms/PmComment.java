package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_COMMENT")
public class PmComment extends BaseAuditEntity {

  private String memberUsername;

  private String memberIcon;

  private String memberIpAddress;

  private String productName;

  private String productAttribute;

  private Integer star;

  private Integer showSts;

  private Integer collectQuantity;

  private Integer viewQuantity;

  private Integer replyQuantity;

  private String content;

  private String pic;

  @OneToMany(mappedBy = "pmComment")
  private List<PmCommentReply> pmCommentReply;

  @ManyToOne(fetch = FetchType.LAZY)
  private PmProduct pmProduct;
}
