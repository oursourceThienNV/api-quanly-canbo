package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.TranferProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranferProfileDTO {
    public Long id;
    public Long product_id;
    public String code;
    public String fullname;
    public String type;
    public String ngay;
    public String co_quan;
    public String status;
    public TranferProfileDTO(TranferProfile tranferProfile){
        this.id=tranferProfile.getId();
        this.product_id=tranferProfile.getProfile_id();
        this.type=tranferProfile.getType();
        this.ngay=tranferProfile.getNgay();
        this.co_quan=tranferProfile.getCo_quan();
        this.status=tranferProfile.getStatus();
    }
}
