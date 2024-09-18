package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.*;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
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

  private String keyword;

  private Integer quantity;

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

  private PromoType promoType;

  private String detailTitle;

  private String detailDesc;

  private Integer sale;

  private Integer review;

  private BigDecimal rate;

  private Integer giftPoint;

  private Integer levelPoint;

  private Integer usePointLimit;

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

  @OneToMany(mappedBy = "pmProduct")
  private List<PmSku> pmSku;
}
