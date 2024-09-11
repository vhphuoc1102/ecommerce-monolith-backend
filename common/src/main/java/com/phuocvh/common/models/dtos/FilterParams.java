package com.phuocvh.common.models.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.NumberFormat;

@AllArgsConstructor
@NoArgsConstructor
public class FilterParams {
  @NumberFormat private Integer page;
  @NumberFormat private Integer limit;
  private String sortBy;
  private Sort.Direction sortType;
  private Boolean unlimited = false;

  public Integer getPage() {
    return (page == null || page <= 0) ? 1 : page;
  }

  public Integer getLimit() {
    return unlimited ? (limit == null || limit <= 0 ? 20 : limit) : Integer.MAX_VALUE;
  }

  public Sort.Direction getSortType() {
    return (sortType == null) ? Sort.Direction.ASC : sortType;
  }

  public Integer getOffset() {
    return (getPage() - 1) * getLimit();
  }

  public Sort getSort() {
    return (sortBy != null) ? Sort.by(getSortType(), sortBy) : null;
  }

  public Pageable getPageable() {
    PageRequest pageRequest = PageRequest.of(page, limit);
    return (sortBy != null) ? pageRequest.withSort(getSortType(), sortBy) : pageRequest;
  }
}
