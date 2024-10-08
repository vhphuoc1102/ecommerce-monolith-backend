package com.phuocvh.common.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseAuditEntity extends BaseEntity {
  public Integer registId;

  private Integer updateId;

  @CreationTimestamp
  @Column(name = "REGIST_TS", nullable = false, updatable = false)
  private LocalDateTime registTs;

  @UpdateTimestamp
  @Column(name = "UPDATE_TS", nullable = false)
  private LocalDateTime updateTs;

  public void generateCreateInfo(Integer userId) {
    this.registId = userId;
    this.updateId = userId;
    this.registTs = LocalDateTime.now();
    this.updateTs = LocalDateTime.now();
  }

  public void generateUpdateInfo(Integer userId) {
    this.updateId = userId;
    this.updateTs = LocalDateTime.now();
  }
}
