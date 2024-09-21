package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmAlbumFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmAlbumPictureRepository
    extends JpaRepository<PmAlbumFile, Integer>, JpaSpecificationExecutor<PmAlbumFile> {}
