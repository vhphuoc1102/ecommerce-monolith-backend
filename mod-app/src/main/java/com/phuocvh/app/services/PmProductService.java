package com.phuocvh.app.services;

import com.phuocvh.app.daos.PmProductDao;
import com.phuocvh.app.dtos.pms.ProductDetailResult;
import com.phuocvh.app.dtos.pms.ProductInfo;
import com.phuocvh.app.dtos.pms.ProductSkuInfo;
import com.phuocvh.app.mappers.PmProductMapper;
import com.phuocvh.app.mappers.PmSkuMapper;
import com.phuocvh.app.repositories.PmAlbumRepository;
import com.phuocvh.app.repositories.PmSkuRepository;
import com.phuocvh.app.repositories.SmFlashSaleRepository;
import com.phuocvh.common.constants.DefaultConstant;
import com.phuocvh.common.models.entities.pms.PmAlbumPicture;
import com.phuocvh.common.models.entities.pms.PmProduct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PmProductService {
  private final PmProductDao pmProductDao;
  private final PmAlbumRepository pmAlbumRepository;
  private final PmSkuRepository pmSkuRepository;
  private final SmFlashSaleRepository smFlashSaleRepository;

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
    getFlashSaleInfo(pmProduct, productInfo);
    getAlbumPicturesWithoutSku(pmProduct, productInfo);
    return productInfo;
  }

  private void getAlbumPicturesWithoutSku(PmProduct pmProduct, ProductInfo productInfo) {
    productInfo.setProductPics(
        pmAlbumRepository
            .findPicturesByProductIdAndProductSkuId(pmProduct.getId(), DefaultConstant.VALUE)
            .stream()
            .map(PmAlbumPicture::getPic)
            .toList());
  }

  private void getFlashSaleInfo(PmProduct pmProduct, ProductInfo productInfo) {
    smFlashSaleRepository
        .findByProductId(pmProduct.getId())
        .ifPresent(
            smFlashSale -> {
              productInfo.setPromoEndTs(smFlashSale.getEndTs());
              productInfo.setPromoStartTs(smFlashSale.getStartTs());
              productInfo.setPromoQuantity(smFlashSale.getQuantity());
            });
  }

  private List<ProductSkuInfo> getProductSkuInfo(PmProduct pmProduct) {
    List<ProductSkuInfo> pmSkus =
        pmSkuRepository.findByPmProduct(pmProduct).stream()
            .map(PmSkuMapper.MAPPER::toInfo)
            .toList();

    return pmSkus;
  }
}
