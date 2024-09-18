package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.pms.ProductSkuInfo;
import com.phuocvh.common.models.entities.pms.PmSku;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PmSkuMapper {
  PmSkuMapper MAPPER = Mappers.getMapper(PmSkuMapper.class);

  @Mapping(target = "productSkuPics", ignore = true)
  @Mapping(target = "productSkuId", source = "id")
  ProductSkuInfo toInfo(PmSku pmSku);
}
