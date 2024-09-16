package com.phuocvh.common.models.entities.oms;

import com.phuocvh.common.constants.ReceiveSts;
import com.phuocvh.common.constants.SendSts;
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
@Table(name = "OM_RETURN_ADDRESS")
public class OmCompanyAddress extends BaseAuditEntity {
  private String companyName; // Name of the company

  private SendSts sendSts;

  private ReceiveSts receiveSts;

  private String name;

  private String phone;

  private String province;

  private String city;

  private String region;

  private String address;
}
