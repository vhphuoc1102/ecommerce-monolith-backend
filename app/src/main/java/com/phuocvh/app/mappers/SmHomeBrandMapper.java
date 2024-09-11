package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.HomeBrandResult;
import com.phuocvh.common.models.entities.sms.SmHomeBrand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmHomeBrandMapper {
  SmHomeBrandMapper MAPPER = Mappers.getMapper(SmHomeBrandMapper.class);

  @Mapping(target = "brandName", ignore = true)
  HomeBrandResult fromEntityToResult(SmHomeBrand smHomeBrand);
}
