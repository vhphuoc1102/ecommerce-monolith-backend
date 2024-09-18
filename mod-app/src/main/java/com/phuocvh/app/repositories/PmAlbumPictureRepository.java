package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmAlbumPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmAlbumPictureRepository
    extends JpaRepository<PmAlbumPicture, Integer>, JpaSpecificationExecutor<PmAlbumPicture> {}
