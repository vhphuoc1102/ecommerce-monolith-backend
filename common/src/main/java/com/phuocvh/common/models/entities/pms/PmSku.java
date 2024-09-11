package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import com.phuocvh.common.utils.JsonConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
  private Map<String, Object> saleProp = new HashMap<>();

  private BigDecimal price;

  private BigDecimal promoPrice;

  @ManyToOne(optional = false)
  private PmProduct pmProduct;

  public PmSku setSaleProp(Map<String, Object> props) {
    this.saleProp = props;
    return this;
  }

  public PmSku addSaleProp(String key, Object value) {
    this.saleProp.put(key, value);
    return this;
  }
}
