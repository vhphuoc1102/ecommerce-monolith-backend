package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.CommentRate;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import com.phuocvh.common.utils.JsonConverter;
import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_COMMENT")
public class PmComment extends BaseAuditEntity {
  private Integer memberId;

  private String memberUsername;

  private String memberIcon;

  private String memberIpAddress;

  private String productName;

  @Convert(converter = JsonConverter.class)
  private Map<String, Object> productAttribute = new HashMap<>();

  private CommentRate rate;

  private Integer showSts;

  private Integer collectQuantity;

  private Integer viewQuantity;

  private Integer replyQuantity;

  private String content;

  @OneToOne(mappedBy = "pmComment")
  private PmCommentReply pmCommentReply;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID")
  private PmProduct pmProduct;
}
