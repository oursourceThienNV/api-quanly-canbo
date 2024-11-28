package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.TranferProfile;
import com.group.samrt.um.domain.uml.TranferProfileDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranferProfileDetailDTO {
    public Long id;
    public Long profile_id;
    public String code;
    public String fullname;
    public String type;
    public String ngay;
    public String co_quan;
    public String chuc_vu;
    public String nam_sinh;
    public String gender;
    public String status;
    public TranferProfileDetailDTO(TranferProfileDetail tranferProfile){
        this.id=tranferProfile.getId();
        this.profile_id=tranferProfile.getProfile_id();
        this.type=tranferProfile.getType();
        this.ngay=tranferProfile.getNgay();
        this.co_quan=tranferProfile.getCo_quan();
        this.fullname=tranferProfile.getFullname();
        this.chuc_vu=tranferProfile.getChuc_vu();
        this.code=tranferProfile.getCode();
        this.nam_sinh=tranferProfile.getNam_sinh();
        this.gender=tranferProfile.getGender();
        this.status=tranferProfile.getStatus();
    }
}
