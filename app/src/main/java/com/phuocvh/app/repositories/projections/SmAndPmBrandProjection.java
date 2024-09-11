package com.phuocvh.app.repositories.projections;

import com.phuocvh.common.models.entities.pms.PmBrand;
import com.phuocvh.common.models.entities.sms.SmHomeBrand;

public interface SmAndPmBrandProjection {
  PmBrand getPmBrand();

  SmHomeBrand getSmHomeBrand();
}
