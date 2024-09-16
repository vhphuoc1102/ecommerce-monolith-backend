package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import com.phuocvh.common.utils.JsonConverter;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
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

  @Convert(converter = JsonConverter.class)
  @Builder.Default
  private Map<String, Object> attribute = new HashMap<>();

  private BigDecimal price;

  private BigDecimal promoPrice;

  @ManyToOne(optional = false)
  @JoinColumn(name = "PRODUCT_ID")
  private PmProduct pmProduct;
}
