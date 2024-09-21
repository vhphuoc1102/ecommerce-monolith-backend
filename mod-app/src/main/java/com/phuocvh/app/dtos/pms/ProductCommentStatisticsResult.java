package com.phuocvh.app.dtos.pms;

import com.phuocvh.common.constants.CommentRate;
import java.math.BigDecimal;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductCommentStatisticsResult {
  private BigDecimal avgRate;
  private Integer review;
  private Map<CommentRate, Integer> commentRateMap;
}
