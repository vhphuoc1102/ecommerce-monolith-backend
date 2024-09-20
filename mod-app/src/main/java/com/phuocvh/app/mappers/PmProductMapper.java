package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.pms.ProductGeneralInfo;
import com.phuocvh.common.models.entities.pms.PmProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PmProductMapper {
  PmProductMapper MAPPER = Mappers.getMapper(PmProductMapper.class);

  @Mapping(target = "productPics", ignore = true)
  @Mapping(target = "productId", source = "id")
  ProductGeneralInfo toInfo(PmProduct pmProduct);
}
