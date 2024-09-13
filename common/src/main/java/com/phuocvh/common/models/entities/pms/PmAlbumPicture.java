package com.phuocvh.common.models.entities.pms;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
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
  @JoinColumn(name = "ALBUM_ID")
  private PmAlbum pmAlbum;
}
