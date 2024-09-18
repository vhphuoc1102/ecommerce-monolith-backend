package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.pms.PmAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PmAlbumRepository
    extends JpaRepository<PmAlbum, Integer>, JpaSpecificationExecutor<PmAlbum> {}
