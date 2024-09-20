package com.phuocvh.app.services;

import com.phuocvh.app.daos.PmProductDao;
import com.phuocvh.app.dtos.pms.ProductCommentResult;
import com.phuocvh.app.dtos.pms.ProductCommentStatisticsResult;
import com.phuocvh.app.mappers.PmCommentMapper;
import com.phuocvh.app.repositories.PmCommentRepository;
import com.phuocvh.common.constants.CommentRate;
import com.phuocvh.common.models.dtos.FilterParams;
import com.phuocvh.common.models.dtos.PaginationResult;
import com.phuocvh.common.models.entities.pms.PmComment;
import com.phuocvh.common.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PmCommentService extends BaseService {
  private final PmProductDao pmProductDao;
  private final PmCommentRepository pmCommentRepository;

  public PaginationResult<ProductCommentResult> getProductComments(
      Integer productId, FilterParams filterParams) {
    pmProductDao.findById(productId);
    Page<PmComment> pmComments =  pmCommentRepository.findByProductId(productId, filterParams.getPageable());
    long total = pmComments.getTotalElements();
    List<ProductCommentResult> results = new ArrayList<>();
    if(total > 0){
      results = pmComments.getContent().stream().map(PmCommentMapper.MAPPER::toResult).toList();
    }

    return PaginationResult.<ProductCommentResult>builder()
        .meta(
            PaginationResult.PaginationMeta.builder()
                .offset(filterParams.getOffset())
                .limit(filterParams.getLimit())
                .total(total)
                .build()
        )
        .data(results)
        .build();
  }

  public ProductCommentStatisticsResult getProductCommentStatistics(Integer productId) {
    pmProductDao.findById(productId);
    List<PmComment> pmComments = pmCommentRepository.findByProductId(productId);
    int review = pmComments.size();
    Map<CommentRate, Integer> commentRateMap = pmComments.stream().collect(
        Collectors.groupingBy(PmComment::getRate, Collectors.summingInt(e -> 1))
    );

    return ProductCommentStatisticsResult.builder()
        .review(review)
        .avgRate(calculateAvgRate(commentRateMap, review))
        .commentRateMap(commentRateMap)
        .build();
  }

  private BigDecimal calculateAvgRate(Map<CommentRate, Integer> commentRateMap, Integer review) {
    int sumRate = 0;
    for(Map.Entry<CommentRate, Integer> entry : commentRateMap.entrySet()){
      sumRate += entry.getKey().getValue() * entry.getValue();
    }
    return BigDecimal.valueOf(sumRate).divide(BigDecimal.valueOf(review), 1, RoundingMode.HALF_UP);
  }
}
