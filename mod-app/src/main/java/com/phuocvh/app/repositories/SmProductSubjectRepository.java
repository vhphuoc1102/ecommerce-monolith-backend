package com.phuocvh.app.repositories;

import com.phuocvh.common.models.entities.sms.SmProductSubject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface SmProductSubjectRepository
    extends JpaRepository<SmProductSubject, Integer>, JpaSpecificationExecutor<SmProductSubject> {
  @Query(
      """
        SELECT s
        FROM SmProductSubject s
        WHERE (s.showSts = com.phuocvh.common.constants.ShowSts.ALWAYS_SHOW)
          OR (s.showSts = com.phuocvh.common.constants.ShowSts.SHOW
          AND s.startTs <= CURRENT_TIMESTAMP AND s.endTs >= CURRENT_TIMESTAMP)
        ORDER BY s.sortOrder DESC
      """)
  List<SmProductSubject> findProductSubjects();
}
