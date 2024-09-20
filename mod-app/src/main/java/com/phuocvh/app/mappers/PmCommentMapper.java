package com.phuocvh.app.mappers;

import com.phuocvh.app.dtos.pms.ProductCommentResult;
import com.phuocvh.common.models.entities.pms.PmComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PmCommentMapper {
  PmCommentMapper MAPPER = Mappers.getMapper(PmCommentMapper.class);

  @Mapping(target = "productId", source = "pmComment.pmProduct.id")
  @Mapping(target = "commentId", source = "pmComment.id")
  ProductCommentResult toResult(PmComment pmComment);
}
