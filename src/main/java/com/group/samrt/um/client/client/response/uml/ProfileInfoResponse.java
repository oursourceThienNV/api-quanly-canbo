package com.group.samrt.um.client.client.response.uml;

import com.group.samrt.um.domain.uml.QuaTrinh;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ProfileInfoResponse {
    public Long id;
    public String code ;
    public String province ;
    public String subsidiary_unit ;
    public String basic_unit ;
    public String fullname;
    public String gender;
    public String other_name;
    public String cap_uy_hien_tai;
    public String cap_uy_kiem;
    public String chuc_vu;
    public String phu_cap_chuc_vu;
    public String nam_sinh;
    public String noi_sinh;
    public String que_quan;
    public String quan_huyen;
    public String tinh_tp;
    public String noi_o_hien_nay;
    public String so_dien_thoai;
    public String dan_toc;
    public String ton_giao;
    public String thanh_phan_gia_dinh;
    public String nghe_nghiep_truoc_td;
    public String ngay_tuyen_dung;
    public String vao_co_quan;
    public String ngay_tham_gia_cm;
    public String ngay_vao_dang;
    public String ngay_chinh_thuc;
    public String ngay_tham_gia_tc;
    public String ngay_nhap_ngu;
    public String ngay_xuat_ngu;
    public String quan_ham;
    public String giao_duc_pt;
    public String hoc_ham_hoc_vi;
    public String ly_luan_chinh_tri;
    public String ngoai_ngu;
    public String cong_tac_chinh;
    public String ngach;
    public String ma_so;
    public String bac_luong;
    public String he_so;
    public String tu_thang;
    public String danh_hieu_duoc_phong;
    public String so_truong_cong_tac;
    public String cong_viec_lau_nam;
    public String khen_thuong;
    public String ky_luat;
    public String suc_khoe;
    public String cao;
    public String can_nang;
    public String nhom_mau;
    public String so_cmnd;
    public String thuong_binh;
    public String liet_sy;
    public List<QuaTrinh> danh_sach_qt;
    public ProfileInfoResponse(){}
}
