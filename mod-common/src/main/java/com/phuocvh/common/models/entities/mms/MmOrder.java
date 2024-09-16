package com.phuocvh.common.models.entities.mms;

import com.phuocvh.common.models.entities.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MmOrder extends BaseEntity {
  private Integer flashSaleOvertime; // Value in seconds. Example: 86400

  private Integer normalOvertime;

  private Integer confirmOvertime;

  private Integer finishOvertime;

  private Integer commentOvertime;
}
