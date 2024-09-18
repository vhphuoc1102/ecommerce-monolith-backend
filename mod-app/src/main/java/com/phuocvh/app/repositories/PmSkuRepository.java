package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmProduct;
import com.phuocvh.common.models.entities.pms.PmSku;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PmSkuRepository
    extends JpaRepository<PmSku, Integer>, JpaSpecificationExecutor<PmSku> {
  @Query(
      """
SELECT pm
FROM PmSku pm
WHERE pm.id = :productSkuId
  AND pm.pmProduct.id = :productId
""")
  Optional<PmSku> findByIdAndProductId(Integer productSkuId, Integer productId);

  List<PmSku> findByPmProduct(PmProduct pmProduct);
}
