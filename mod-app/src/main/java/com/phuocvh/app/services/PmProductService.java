package com.phuocvh.app.services;

import com.phuocvh.app.daos.MmMemberLevelDao;
import com.phuocvh.app.daos.PmProductDao;
import com.phuocvh.app.daos.UmMemberDao;
import com.phuocvh.app.dtos.pms.*;
import com.phuocvh.app.mappers.PmProductMapper;
import com.phuocvh.app.mappers.PmSkuMapper;
import com.phuocvh.app.repositories.PmAlbumRepository;
import com.phuocvh.app.repositories.PmSkuRepository;
import com.phuocvh.app.repositories.SmFlashSaleRepository;
import com.phuocvh.common.constants.ActiveSts;
import com.phuocvh.common.constants.DefaultConstant;
import com.phuocvh.common.constants.PromoType;
import com.phuocvh.common.models.entities.pms.PmAlbumPicture;
import com.phuocvh.common.models.entities.pms.PmMemberPrice;
import com.phuocvh.common.models.entities.pms.PmProduct;
import com.phuocvh.common.models.entities.sms.SmFlashSale;
import com.phuocvh.common.service.BaseService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PmProductService extends BaseService {
  private final PmProductDao pmProductDao;
  private final PmAlbumRepository pmAlbumRepository;
  private final PmSkuRepository pmSkuRepository;
  private final SmFlashSaleRepository smFlashSaleRepository;
  private final UmMemberDao umMemberDao;
  private final MmMemberLevelDao mmMemberLevelDao;

  public ProductDetailResult getProductDetail(Integer memberId, Integer productId) {
    PmProduct pmProduct = pmProductDao.findById(productId);
    ProductInfo productInfo = getProductInfo(memberId, pmProduct);
    Map<Integer, ProductSkuInfo> productSkuInfos = getProductSkuInfo(memberId, pmProduct);
    return ProductDetailResult.builder()
        .productInfo(productInfo)
        .productSkuInfos(productSkuInfos)
        .build();
  }

  private ProductInfo getProductInfo(Integer memberId, PmProduct pmProduct) {
    ProductGeneralInfo productGeneralInfo = PmProductMapper.MAPPER.toInfo(pmProduct);
    ProductInfo productInfo = new ProductInfo();
    productInfo.setProductGeneralInfo(productGeneralInfo);
    getProductAlbum(pmProduct, productInfo);
    getProductPrice(memberId, pmProduct, productInfo, pmProduct.getPromoType());
    return productInfo;
  }

  private Map<Integer, ProductSkuInfo> getProductSkuInfo(Integer memberId, PmProduct pmProduct) {
    List<ProductSkuInfo> pmSkus =
        pmSkuRepository.findByPmProduct(pmProduct).stream()
            .map(PmSkuMapper.MAPPER::toInfo)
            .peek(
                productSkuInfo -> {
                  getProductSkuAlbum(pmProduct, productSkuInfo);
                  getProductSkuPrice(memberId, pmProduct, productSkuInfo, pmProduct.getPromoType());
                })
            .toList();

    return pmSkus.stream()
        .collect(
            Collectors.toMap(
                sku -> sku.getProductSkuGeneralInfo().getProductSkuId(), Function.identity()));
  }

  private void getProductPrice(
      Integer memberId, PmProduct pmProduct, ProductInfo productInfo, PromoType promoType) {
    switch (promoType) {
      case FLASH_SALE -> getProductFlashSale(pmProduct, productInfo);
      case MEMBER -> getProductMemberPrice(memberId, pmProduct, productInfo);
      case LADDER -> getProductLadderPrice(pmProduct, productInfo);
      case REDUCE -> getProductReducePrice(pmProduct, productInfo);
      default -> {}
    }
  }

  private void getProductSkuPrice(
      Integer memberId, PmProduct pmProduct, ProductSkuInfo productSkuInfo, PromoType promoType) {
    switch (promoType) {
      case FLASH_SALE -> getProductSkuFlashSale(pmProduct, productSkuInfo);
      case MEMBER -> getProductSkuMemberPrice(memberId, pmProduct, productSkuInfo);
      case LADDER -> getProductSkuLadderPrice(pmProduct, productSkuInfo);
      case REDUCE -> getProductSkuReducePrice(pmProduct, productSkuInfo);
      default -> {}
    }
  }

  private void getProductSkuFlashSale(PmProduct pmProduct, ProductSkuInfo productSkuInfo) {
    List<SmFlashSale> smFlashSales =
        smFlashSaleRepository.findByProductIdAndProductSkuId(
            pmProduct.getId(), productSkuInfo.getProductSkuGeneralInfo().getProductSkuId());
    if (CollectionUtils.isEmpty(smFlashSales)) {
      return;
    }
    SmFlashSale smFlashSale = getFirst(smFlashSales);
    ProductOrSkuFlashSalePrice flashSalePrice =
        ProductOrSkuFlashSalePrice.builder()
            .promoQuantity(smFlashSale.getQuantity())
            .promoPrice(smFlashSale.getPrice())
            .promoEndTs(smFlashSale.getEndTs())
            .promoStartTs(smFlashSale.getStartTs())
            .build();

    productSkuInfo.setFlashSalePrice(flashSalePrice);
  }

  private void getProductSkuReducePrice(PmProduct pmProduct, ProductSkuInfo productSkuInfo) {
    List<ProductOrSkuReducePrice> reducePrices =
        pmProduct.getPmReducePrice().stream()
            .filter(
                price ->
                    Objects.equals(price.getActiveSts(), ActiveSts.ACTIVE)
                        && Objects.equals(
                            price.getPmSku().getId(),
                            productSkuInfo.getProductSkuGeneralInfo().getProductSkuId()))
            .map(
                price ->
                    ProductOrSkuReducePrice.builder()
                        .fullPrice(price.getFullPrice())
                        .promoPrice(price.getReducePrice())
                        .build())
            .collect(Collectors.toList());
    productSkuInfo.setReducePrices(reducePrices);
  }

  private void getProductSkuLadderPrice(PmProduct pmProduct, ProductSkuInfo productSkuInfo) {
    List<ProductOrSkuLadderPrice> ladderPrices =
        pmProduct.getPmLadderPrice().stream()
            .filter(
                price ->
                    Objects.equals(price.getActiveSts(), ActiveSts.ACTIVE)
                        && Objects.equals(
                            price.getPmSku().getId(),
                            productSkuInfo.getProductSkuGeneralInfo().getProductSkuId()))
            .map(
                price ->
                    ProductOrSkuLadderPrice.builder()
                        .quantity(price.getQuantity())
                        .discount(price.getDiscount())
                        .promoPrice(price.getPrice())
                        .build())
            .collect(Collectors.toList());
    productSkuInfo.setLadderPrices(ladderPrices);
  }

  private void getProductSkuMemberPrice(
      Integer memberId, PmProduct pmProduct, ProductSkuInfo productSkuInfo) {
    Map<Integer, List<PmMemberPrice>> memberPriceByLevelId =
        pmProduct.getPmMemberPrice().stream()
            .filter(
                price ->
                    Objects.equals(
                        price.getPmSku().getId(),
                        productSkuInfo.getProductSkuGeneralInfo().getProductSkuId()))
            .collect(Collectors.groupingBy(PmMemberPrice::getMemberLevelId));
    Integer memberLevelId = umMemberDao.findById(memberId).getMemberLevelId();
    mmMemberLevelDao.findById(memberLevelId);
    ProductOrSkuMemberPrice memberPrice =
        ProductOrSkuMemberPrice.builder()
            .promoPrice(getLast(memberPriceByLevelId.get(memberLevelId)).getMemberPrice())
            .build();
    productSkuInfo.setMemberPrice(memberPrice);
  }

  private void getProductAlbum(PmProduct pmProduct, ProductInfo productInfo) {
    productInfo
        .getProductGeneralInfo()
        .setProductPics(
            pmAlbumRepository
                .findPicturesByProductIdAndProductSkuId(pmProduct.getId(), DefaultConstant.VALUE)
                .stream()
                .map(PmAlbumPicture::getPic)
                .toList());
  }

  private void getProductSkuAlbum(PmProduct pmProduct, ProductSkuInfo productSkuInfo) {
    productSkuInfo
        .getProductSkuGeneralInfo()
        .setProductSkuPics(
            pmAlbumRepository
                .findPicturesByProductIdAndProductSkuId(
                    pmProduct.getId(), productSkuInfo.getProductSkuGeneralInfo().getProductSkuId())
                .stream()
                .map(PmAlbumPicture::getPic)
                .toList());
  }

  private void getProductFlashSale(PmProduct pmProduct, ProductInfo productInfo) {
    List<SmFlashSale> smFlashSales = smFlashSaleRepository.findByProductId(pmProduct.getId());
    if (CollectionUtils.isEmpty(smFlashSales)) {
      return;
    }
    SmFlashSale smFlashSale = getFirst(smFlashSales);
    ProductOrSkuFlashSalePrice flashSalePrice = ProductOrSkuFlashSalePrice.builder().build();
    flashSalePrice.setPromoEndTs(smFlashSale.getEndTs());
    flashSalePrice.setPromoStartTs(smFlashSale.getStartTs());
    if (smFlashSale.getProductSkuId() == DefaultConstant.VALUE) {
      flashSalePrice.setPromoQuantity(smFlashSale.getQuantity());
      flashSalePrice.setPromoPrice(smFlashSale.getPrice());
    } else {
      flashSalePrice.setPromoQuantity(DefaultConstant.VALUE);
    }
    productInfo.setFlashSalePrice(flashSalePrice);
  }

  private void getProductMemberPrice(
      Integer memberId, PmProduct pmProduct, ProductInfo productInfo) {
    Map<Integer, List<PmMemberPrice>> memberPriceByLevelId =
        pmProduct.getPmMemberPrice().stream()
            .collect(Collectors.groupingBy(PmMemberPrice::getMemberLevelId));
    Integer memberLevelId = umMemberDao.findById(memberId).getMemberLevelId();
    mmMemberLevelDao.findById(memberLevelId);
    ProductOrSkuMemberPrice memberPrice =
        ProductOrSkuMemberPrice.builder()
            .promoPrice(getLast(memberPriceByLevelId.get(memberLevelId)).getMemberPrice())
            .build();
    productInfo.setMemberPrice(memberPrice);
  }

  private void getProductLadderPrice(PmProduct pmProduct, ProductInfo productInfo) {
    List<ProductOrSkuLadderPrice> ladderPrices =
        pmProduct.getPmLadderPrice().stream()
            .filter(price -> Objects.equals(price.getActiveSts(), ActiveSts.ACTIVE))
            .map(
                price ->
                    ProductOrSkuLadderPrice.builder()
                        .quantity(price.getQuantity())
                        .discount(price.getDiscount())
                        .promoPrice(price.getPrice())
                        .build())
            .collect(Collectors.toList());
    productInfo.setLadderPrices(ladderPrices);
  }

  private void getProductReducePrice(PmProduct pmProduct, ProductInfo productInfo) {
    List<ProductOrSkuReducePrice> reducePrices =
        pmProduct.getPmReducePrice().stream()
            .filter(price -> Objects.equals(price.getActiveSts(), ActiveSts.ACTIVE))
            .map(
                price ->
                    ProductOrSkuReducePrice.builder()
                        .fullPrice(price.getFullPrice())
                        .promoPrice(price.getReducePrice())
                        .build())
            .collect(Collectors.toList());
    productInfo.setReducePrices(reducePrices);
  }
}
