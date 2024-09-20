package com.phuocvh.app.dtos.pms;

import com.phuocvh.common.constants.NewSts;
import com.phuocvh.common.constants.PreviewSts;
import com.phuocvh.common.constants.PromoType;
import com.phuocvh.common.constants.RecommendSts;
import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductGeneralInfo {
  private Integer productId;

  private String name;

  private String title;

  private String subtitle;

  private String pic;

  private String description;

  private Integer stock;

  private Integer lowStock;

  private BigDecimal weight;

  private NewSts newSts;

  private RecommendSts recommendSts;

  private PreviewSts previewSts;

  private BigDecimal price;

  private String detailTitle;

  private String detailDesc;

  private Integer sale;

  private Integer review;

  private BigDecimal rate;

  private List<String> productPics;

  private PromoType promoType;
}
