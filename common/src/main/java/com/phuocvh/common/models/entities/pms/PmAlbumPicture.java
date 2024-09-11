package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PM_ALBUM_PICTURE")
public class PmAlbumPicture extends BaseAuditEntity {
  private String pic;

  @ManyToOne(fetch = FetchType.LAZY)
  private PmAlbum pmAlbum;
}
