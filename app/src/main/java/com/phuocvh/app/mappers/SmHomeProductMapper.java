package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.HomeProductResult;
import com.phuocvh.common.models.entities.sms.SmHomeProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SmHomeProductMapper {
  SmHomeProductMapper MAPPER = Mappers.getMapper(SmHomeProductMapper.class);

  HomeProductResult fromEntityToResult(SmHomeProduct smHomeProduct);

  default List<String> separateTags(String tags) {
    return List.of(tags.split(","));
  }
}
