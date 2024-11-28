package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    public Long id;
    public String code ;
    public String fullname;
    public String que_quan;
    public String quan_huyen;
    public String tinh_tp;
    public String noi_o_hien_nay;
    public String so_dien_thoai;
    public String status;
    public ProfileDTO(Profile profile){
        this.id=profile.getId();
        this.code=profile.getCode();
        this.fullname=profile.getFullname();
        this.que_quan=profile.getQue_quan();
        this.quan_huyen=profile.getQuan_huyen();
        this.tinh_tp=profile.getTinh_tp();
        this.noi_o_hien_nay=profile.getNoi_o_hien_nay();
        this.so_dien_thoai=profile.getSo_dien_thoai();
        this.status=profile.getStatus();
    }
}
