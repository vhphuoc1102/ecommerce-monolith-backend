package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.CartItemResult;
import com.phuocvh.common.models.entities.oms.OmCartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OmCartItemMapper {
  OmCartItemMapper MAPPER = Mappers.getMapper(OmCartItemMapper.class);

  @Mapping(target = "isActive", source = "java(omCartItem.getActiveSts().getIsActive())")
  CartItemResult toResult(OmCartItem omCartItem);
}
