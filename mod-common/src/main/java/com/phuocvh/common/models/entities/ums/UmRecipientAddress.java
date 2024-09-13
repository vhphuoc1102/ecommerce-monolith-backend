package com.phuocvh.common.models.entities.ums;

import com.phuocvh.common.constants.ActiveSts;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "UM_RECIPIENT_ADDRESS")
public class UmRecipientAddress extends BaseAuditEntity {
  private String name;

  private String phone;

  private String province;

  private String city;

  private String region;

  private String address;

  private ActiveSts activeSts;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MEMBER_ID")
  private UmMember umMember;
}
