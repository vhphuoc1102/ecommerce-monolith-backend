package com.phuocvh.common.models.entities.ums;

import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "UM_MEMBER_CREDENTIAL")
public class UmMemberCredential extends BaseAuditEntity implements UserDetails {
  private String username = "";

  private String password = "";

  private String email = "";

  private String phone = "";

  private String type = "";

  @Override
  @Transient
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }
}
