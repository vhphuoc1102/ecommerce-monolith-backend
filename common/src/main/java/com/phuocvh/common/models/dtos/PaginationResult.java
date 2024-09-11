package com.phuocvh.common.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PaginationResult<T> {
  private PaginationMeta meta;
  private List<T> data;

  @Getter
  @Setter
  @Builder
  public static class PaginationMeta {
    private int offset;

    private int limit;

    private int total;
  }
}
