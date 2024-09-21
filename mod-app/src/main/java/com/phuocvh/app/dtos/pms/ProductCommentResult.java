package com.phuocvh.app.dtos.pms;

import com.phuocvh.common.utils.JsonConverter;
import jakarta.persistence.Convert;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductCommentResult {
  private Integer commentId;

  private Integer productId;

  private String memberUsername;

  private String memberIcon;

  private String productName;

  @Convert(converter = JsonConverter.class)
  @Builder.Default
  private Map<String, Object> productAttribute = new HashMap<>();

  private Integer rate;

  private Integer collectQuantity;

  private Integer viewQuantity;

  private Integer replyQuantity;

  private String content;

  private String pic;
}
