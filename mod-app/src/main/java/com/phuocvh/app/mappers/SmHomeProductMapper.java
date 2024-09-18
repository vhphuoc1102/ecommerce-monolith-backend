package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.sms.HomeProductResult;
import com.phuocvh.common.models.entities.sms.SmHomeProduct;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmHomeProductMapper {
  SmHomeProductMapper MAPPER = Mappers.getMapper(SmHomeProductMapper.class);

  @Mapping(
      target = "tags",
      source = "tags",
      defaultExpression = "java(separateTags(smHomeProduct.getTags()))")
  HomeProductResult fromEntityToResult(SmHomeProduct smHomeProduct);

  default List<String> separateTags(String tags) {
    return List.of(tags.split(","));
  }
}
