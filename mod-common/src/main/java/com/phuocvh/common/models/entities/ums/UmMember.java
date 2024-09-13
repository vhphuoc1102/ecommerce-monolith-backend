package com.phuocvh.common.models.entities.ums;

import com.phuocvh.common.constants.ActiveSts;
import com.phuocvh.common.constants.Gender;
import com.phuocvh.common.models.entities.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "UM_MEMBER")
public class UmMember extends BaseAuditEntity {
  private String name;

  private String nickname;

  private String icon;

  private Gender gender;

  private ActiveSts activeSts;

  private Integer giftPoint;

  private Integer levelPoint;

  private Integer memberLevelId;

  @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
  private UmMemberCredential umMemberCredential;

  @OneToMany(mappedBy = "umMember", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
  private List<UmRecipientAddress> recipientAddresses;
}
