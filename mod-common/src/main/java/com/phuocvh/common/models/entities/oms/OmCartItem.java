package com.phuocvh.common.models.entities.oms;

import com.phuocvh.common.constants.ActiveSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import com.phuocvh.common.utils.JsonConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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
@Table(name = "OM_CART_ITEM")
public class OmCartItem extends BaseAuditEntity {
  private String title = "";

  private String subtitle = "";

  private Integer quantity = 0;

  private BigDecimal price = BigDecimal.ZERO;

  private Integer memberId = -1;

  private Integer productId = -1;

  private Integer productSkuId = -1;

  private String productName = "";

  private String productPic = "";

  private String productSn = "";

  private String productSkuCode = "";

  @Convert(converter = JsonConverter.class)
  private Map<String, Object> productAttribute = new HashMap<>();

  private String brandName = "";

  private ActiveSts activeSts = ActiveSts.ACTIVE;
}
