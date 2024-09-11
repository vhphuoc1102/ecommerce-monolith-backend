package com.phuocvh.common.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseAuditEntity extends BaseEntity{
  public Integer registId;

  private Integer updateId;

  @CreationTimestamp
  @Column(name = "REGIST_TS", updatable = false)
  private LocalDateTime registTs;

  @UpdateTimestamp
  @Column(name = "UPDATE_TS")
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
