package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.oms.OmOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OmOrderRepository extends JpaRepository<OmOrder, Integer> {}
