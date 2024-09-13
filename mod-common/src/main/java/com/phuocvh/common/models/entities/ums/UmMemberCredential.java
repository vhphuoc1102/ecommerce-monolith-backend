package com.phuocvh.common.models.entities.ums;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "UM_MEMBER_CREDENTIAL")
public class UmMemberCredential extends BaseAuditEntity {
  private String username;

  private String password;

  private String email;

  private String phone;

  private String socialTypes;
}
