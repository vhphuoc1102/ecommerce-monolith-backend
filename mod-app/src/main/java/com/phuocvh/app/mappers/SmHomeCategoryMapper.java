package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.HomeCategoryResult;
import com.phuocvh.common.models.entities.sms.SmHomeCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmHomeCategoryMapper {
  SmHomeCategoryMapper MAPPER = Mappers.getMapper(SmHomeCategoryMapper.class);

  HomeCategoryResult fromEntityToResult(SmHomeCategory smHomeCategory);
}
