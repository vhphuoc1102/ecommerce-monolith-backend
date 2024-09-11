package com.phuocvh.app.services;

import com.phuocvh.app.dtos.HomeBrandResult;
import com.phuocvh.app.dtos.HomeCategoryResult;
import com.phuocvh.app.dtos.HomeProductResult;
import com.phuocvh.app.mappers.SmHomeBrandMapper;
import com.phuocvh.app.mappers.SmHomeCategoryMapper;
import com.phuocvh.app.mappers.SmHomeProductMapper;
import com.phuocvh.app.repositories.*;
import com.phuocvh.common.constants.ProductSubject;
import com.phuocvh.common.constants.ShowSts;
import com.phuocvh.common.models.dtos.FilterParams;
import com.phuocvh.common.models.dtos.PaginationResult;
import com.phuocvh.common.models.entities.pms.PmBrand;
import com.phuocvh.common.models.entities.pms.PmCategory;
import com.phuocvh.common.models.entities.sms.SmHomeBrand;
import com.phuocvh.common.models.entities.sms.SmHomeCategory;
import com.phuocvh.common.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeService extends BaseService {
  private final SmHomeBrandRepository smHomeBrandRepository;
  private final SmHomeCategoryRepository smHomeCategoryRepository;
  private final SmHomeProductRepository smHomeProductRepository;
  private final PmBrandRepository pmBrandRepository;
  private final PmCategoryRepository pmCategoryRepository;

  public List<HomeBrandResult> findHomeBrands() {
    List<SmHomeBrand> smBrands =
        smHomeBrandRepository.findByShowStsEqualsOrderBySortOrderDesc(ShowSts.SHOW);
    List<Integer> brandIds = smBrands.stream().map(SmHomeBrand::getBrandId).toList();
    Map<Integer, PmBrand> pmBrands =
        pmBrandRepository.findByIdIn(brandIds).stream()
            .collect(Collectors.toMap(PmBrand::getId, Function.identity()));
    return smBrands.stream()
        .map(
            smBrand -> {
              HomeBrandResult result = SmHomeBrandMapper.MAPPER.fromEntityToResult(smBrand);
              result.setBrandName(pmBrands.get(smBrand.getBrandId()).getName());
              return result;
            })
        .toList();
  }

  public List<HomeBrandResult> findHomeBrand() {
    return smHomeBrandRepository.findHomeBrands().stream()
        .map(projection ->
            HomeBrandResult.builder()
                .brandId(projection.getSmHomeBrand().getBrandId())
                .brandName(projection.getPmBrand().getName())
                .pic(projection.getSmHomeBrand().getPic())
                .build()
        ).toList();
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
      ProductSubject subject, FilterParams filterParam) {
    Long total = smHomeProductRepository.countBySubject(subject);
    PaginationResult.PaginationMeta meta =
        PaginationResult.PaginationMeta.builder()
            .total(total.intValue())
            .offset(filterParam.getOffset())
            .limit(filterParam.getLimit())
            .build();
    List<HomeProductResult> results = new ArrayList<>();
    if (total > 0) {
      results =
          smHomeProductRepository
              .findBySubjectOrderBySortOrderDesc(subject, filterParam.getPageable())
              .stream()
              .map(SmHomeProductMapper.MAPPER::fromEntityToResult)
              .toList();
    }
    return PaginationResult.<HomeProductResult>builder().meta(meta).data(results).build();
  }
}
