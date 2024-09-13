package com.phuocvh.common.models.entities.pms;

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
  private String name;

  private String coverPicture;

  private Integer pictureQuantity;

  private String description;

  @OneToMany(mappedBy = "pmAlbum")
  private List<PmAlbumPicture> pmAlbumPicture;
}
