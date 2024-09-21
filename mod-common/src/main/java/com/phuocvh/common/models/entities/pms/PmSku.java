package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import com.phuocvh.common.utils.JsonConverter;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_SKU")
public class PmSku extends BaseAuditEntity {
  private String name;

  private String pic;

  private Integer stock;

  private Integer lowStock;

  private Integer quantity;

  @Convert(converter = JsonConverter.class)
  @Builder.Default
  private Map<String, Object> attribute = new HashMap<>();

  private BigDecimal price;

  private BigDecimal promoPrice;

  private Integer promoQuantity;

  @ManyToOne(optional = false)
  @JoinColumn(name = "PRODUCT_ID")
  private PmProduct pmProduct;

  @OneToMany(mappedBy = "pmSku")
  private List<PmMemberPrice> pmMemberPrices;

  @OneToMany(mappedBy = "pmSku")
  private List<PmLadderPrice> pmLadderPrices;

  @OneToMany(mappedBy = "pmSku")
  private List<PmReducePrice> pmReducePrices;
}
