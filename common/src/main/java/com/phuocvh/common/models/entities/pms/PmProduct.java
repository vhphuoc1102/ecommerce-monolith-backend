package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.*;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_PRODUCT")
public class PmProduct extends BaseAuditEntity {
  private String name;

  private String title;

  private String subtitle;

  private String pic;

  private String productSn;

  private String description;

  private String keywords;

  private String note;

  private Integer stock;

  private Integer lowStock;

  private BigDecimal weight;

  private ActiveSts activeSts;

  private PublishSts publishSts;

  private NewSts newSts;

  private RecommendSts recommendSts;

  private VerifySts verifySts;

  private PreviewSts previewSts;

  private BigDecimal price;

  private BigDecimal originPrice;

  private BigDecimal promoPrice;

  private LocalDateTime promoStartTs;

  private LocalDateTime promoEndTs;

  private Integer promoPerLimit;

  private Integer promoType;

  private String detailTitle;

  private String detailDesc;

  private String brandName;

  private String categoryName;

  private Integer sale;

  private Integer reviewQuantity;

  private BigDecimal averageRate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CATEGORY_ID")
  private PmCategory pmCategory;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BRAND_ID")
  private PmBrand pmBrand;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ATTRIBUTE_CATEGORY_ID")
  private PmAttributeGroup pmAttributeGroup;

  @OneToMany(mappedBy = "pmProduct")
  private List<PmProductAttribute> pmProductAttribute;

  @OneToMany(mappedBy = "pmProduct")
  private List<PmLadderPrice> pmLadderPrice;

  @OneToMany(mappedBy = "pmProduct")
  private List<PmMemberPrice> pmMemberPrice;

  @OneToMany(mappedBy = "pmProduct")
  private List<PmReducePrice> pmReducePrice;
}
