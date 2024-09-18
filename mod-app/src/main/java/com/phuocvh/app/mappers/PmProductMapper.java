package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.pms.ProductInfo;
import com.phuocvh.common.models.entities.pms.PmProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PmProductMapper {
  PmProductMapper MAPPER = Mappers.getMapper(PmProductMapper.class);

  @Mapping(target = "promoStartTs", ignore = true)
  @Mapping(target = "promoQuantity", ignore = true)
  @Mapping(target = "promoEndTs", ignore = true)
  @Mapping(target = "productPics", ignore = true)
  @Mapping(target = "productId", source = "id")
  ProductInfo toInfo(PmProduct pmProduct);
}
