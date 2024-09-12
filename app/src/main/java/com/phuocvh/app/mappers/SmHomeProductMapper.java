package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.HomeProductResult;
import com.phuocvh.common.models.entities.sms.SmHomeProduct;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmHomeProductMapper {
  SmHomeProductMapper MAPPER = Mappers.getMapper(SmHomeProductMapper.class);

  @Mapping(target = "title", source = "")
  @Mapping(target = "subtitle", source = "")
  @Mapping(target = "stock", source = "")
  @Mapping(target = "sale", source = "")
  @Mapping(target = "reviews", source = "")
  @Mapping(target = "ratings", source = "")
  @Mapping(target = "promoPrice", source = "")
  @Mapping(target = "productName", source = "")
  @Mapping(target = "price", source = "")
  @Mapping(
      target = "tags",
      source = "tags",
      defaultExpression = "java(separateTags(smHomeProduct.getTags()))")
  HomeProductResult fromEntityToResult(SmHomeProduct smHomeProduct);

  default List<String> separateTags(String tags) {
    return List.of(tags.split(","));
  }
}
