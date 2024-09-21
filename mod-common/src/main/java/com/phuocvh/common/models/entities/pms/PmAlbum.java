package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.constants.AlbumType;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_ALBUM")
public class PmAlbum extends BaseAuditEntity {
  private Integer productId;

  private Integer productSkuId;

  private String name;

  private String coverPicture;

  private Integer pictureQuantity;

  private String description;

  private AlbumType albumType;

  @OneToMany(mappedBy = "pmAlbum")
  private List<PmAlbumFile> pmAlbumFile;
}
