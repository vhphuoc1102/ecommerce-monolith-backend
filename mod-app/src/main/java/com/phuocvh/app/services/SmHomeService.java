package com.phuocvh.app.services;

import com.phuocvh.app.dtos.pms.ProductSubjectResult;
import com.phuocvh.app.dtos.sms.HomeBrandResult;
import com.phuocvh.app.dtos.sms.HomeCategoryResult;
import com.phuocvh.app.dtos.sms.HomeProductResult;
import com.phuocvh.app.mappers.SmHomeCategoryMapper;
import com.phuocvh.app.mappers.SmHomeProductMapper;
import com.phuocvh.app.repositories.*;
import com.phuocvh.common.constants.ProductSubjectType;
import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.dtos.FilterParams;
import com.phuocvh.common.models.dtos.PaginationResult;
import com.phuocvh.common.models.entities.pms.PmBrand;
import com.phuocvh.common.models.entities.pms.PmCategory;
import com.phuocvh.common.models.entities.sms.SmHomeCategory;
import com.phuocvh.common.models.entities.sms.SmHomeProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmHomeService {
  private final SmHomeBrandRepository smHomeBrandRepository;
  private final SmHomeCategoryRepository smHomeCategoryRepository;
  private final SmHomeProductRepository smHomeProductRepository;
  private final PmCategoryRepository pmCategoryRepository;
  private final SmProductSubjectRepository smProductSubjectRepository;
  private final PmBrandRepository pmBrandRepository;

  public List<HomeBrandResult> findHomeBrands() {
    return smHomeBrandRepository.findHomeBrands().stream()
        .map(
            projection ->
                HomeBrandResult.builder()
                    .brandId(projection.getSmHomeBrand().getBrandId())
                    .brandName(projection.getPmBrand().getName())
                    .pic(projection.getSmHomeBrand().getPic())
                    .build())
        .toList();
  }

  public List<HomeCategoryResult> findHomeCategories() {
    List<SmHomeCategory> smCategories =
        smHomeCategoryRepository.findByShowStsEqualsOrderBySortOrderDesc(ShowSts.SHOW);
    List<Integer> categoryIds = smCategories.stream().map(SmHomeCategory::getCategoryId).toList();
    Map<Integer, PmCategory> pmCategories =
        pmCategoryRepository.findByIdIn(categoryIds).stream()
            .collect(Collectors.toMap(PmCategory::getId, Function.identity()));
    return smCategories.stream()
        .map(
            smCategory -> {
              HomeCategoryResult result =
                  SmHomeCategoryMapper.MAPPER.fromEntityToResult(smCategory);
              result.setCategoryName(pmCategories.get(smCategory.getCategoryId()).getName());
              return result;
            })
        .toList();
  }

  public PaginationResult<HomeProductResult> findHomeProducts(
      Integer productSubjectId, FilterParams filterParam) {
    Page<SmHomeProduct> smHomeProductPage =
        smHomeProductRepository.findHomeProducts(productSubjectId, filterParam.getPageable());

    long total = smHomeProductPage.getTotalElements();
    List<HomeProductResult> results = new ArrayList<>();
    if (total > 0) {
      results =
          smHomeProductPage.getContent().stream()
              .map(SmHomeProductMapper.MAPPER::fromEntityToResult)
              .toList();
    }
    return PaginationResult.<HomeProductResult>builder()
        .meta(
            PaginationResult.PaginationMeta.builder()
                .offset(filterParam.getOffset())
                .limit(filterParam.getLimit())
                .total(total)
                .build())
        .data(results)
        .build();
  }

  public List<ProductSubjectResult> findProductSubjects() {
    return smProductSubjectRepository.findProductSubjects().stream()
        .map(
            subject ->
                ProductSubjectResult.builder()
                    .productSubjectId(subject.getId())
                    .subjectId(subject.getSubjectId())
                    .subjectName(findSubjectName(subject.getSubjectId(), subject.getSubjectType()))
                    .build())
        .toList();
  }

  private String findSubjectName(Integer subjectId, ProductSubjectType subjectType) {
    return switch (subjectType) {
      case NEW_ARRIVAL, BEST_SELLER, RECOMMENDED -> subjectType.getName();
      case CATEGORY ->
          pmCategoryRepository
              .findById(subjectId)
              .map(PmCategory::getName)
              .orElse(StringUtils.EMPTY);
      case BRAND ->
          pmBrandRepository.findById(subjectId).map(PmBrand::getName).orElse(StringUtils.EMPTY);
    };
  }
}
