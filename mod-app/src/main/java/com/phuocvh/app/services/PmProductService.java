package com.phuocvh.app.services;

import com.phuocvh.app.daos.PmProductDao;
import com.phuocvh.app.dtos.pms.ProductDetailResult;
import com.phuocvh.app.dtos.pms.ProductInfo;
import com.phuocvh.app.dtos.pms.ProductSkuInfo;
import com.phuocvh.app.mappers.PmProductMapper;
import com.phuocvh.app.mappers.PmSkuMapper;
import com.phuocvh.app.repositories.PmAlbumPictureRepository;
import com.phuocvh.app.repositories.PmAlbumRepository;
import com.phuocvh.app.repositories.PmSkuRepository;
import com.phuocvh.common.models.entities.pms.PmProduct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PmProductService {
  private final PmProductDao pmProductDao;
  private final PmAlbumRepository pmAlbumRepository;
  private final PmAlbumPictureRepository pmAlbumPictureRepository;
  private final PmSkuRepository pmSkuRepository;

  public ProductDetailResult get(Integer productId) {
    PmProduct pmProduct = pmProductDao.findById(productId);
    ProductInfo productInfo = getProductInfo(pmProduct);
    List<ProductSkuInfo> productSkuInfos = getProductSkuInfo(pmProduct);
    return ProductDetailResult.builder()
        .productInfo(productInfo)
        .productSkuInfos(productSkuInfos)
        .build();
  }

  private ProductInfo getProductInfo(PmProduct pmProduct) {
    ProductInfo productInfo = PmProductMapper.MAPPER.toInfo(pmProduct);
    return productInfo;
  }

  private List<ProductSkuInfo> getProductSkuInfo(PmProduct pmProduct) {
    List<ProductSkuInfo> pmSkus =
        pmSkuRepository.findByPmProduct(pmProduct).stream()
            .map(PmSkuMapper.MAPPER::toInfo)
            .toList();

    return pmSkus;
  }
}
