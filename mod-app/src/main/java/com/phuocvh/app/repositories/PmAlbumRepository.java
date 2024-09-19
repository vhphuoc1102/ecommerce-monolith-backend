package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmAlbum;
import com.phuocvh.common.models.entities.pms.PmAlbumPicture;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PmAlbumRepository
    extends JpaRepository<PmAlbum, Integer>, JpaSpecificationExecutor<PmAlbum> {
  @Query(
      """
    SELECT pap
    FROM PmAlbum pa
    JOIN FETCH PmAlbumPicture pap
    WHERE pa.productId = :productId
    AND pa.productSkuId = :productSkuId
""")
  List<PmAlbumPicture> findPicturesByProductIdAndProductSkuId(
      Integer productId, Integer productSkuId);
}
