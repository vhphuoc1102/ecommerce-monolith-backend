package com.phuocvh.app.dtos.pms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductSubjectResult {
  private Integer productSubjectId;

  private Integer subjectId;

  private String subjectName;
}
