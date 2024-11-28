package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="code")
    public String code ;
    @Column(name="province")
    public String province ;
    @Column(name="subsidiary_unit")
    public String subsidiary_unit ;
    @Column(name="basic_unit")
    public String basic_unit ;
    @Column(name="fullname")
    public String fullname;
    @Column(name="gender")
    public String gender;
    @Column(name="other_name")
    public String other_name;
    @Column(name="cap_uy_hien_tai")
    public String cap_uy_hien_tai;
    @Column(name="cap_uy_kiem")
    public String cap_uy_kiem;
    @Column(name="chuc_vu")
    public String chuc_vu;
    @Column(name="phu_cap_chuc_vu")
    public String phu_cap_chuc_vu;
    @Column(name="nam_sinh")
    public String nam_sinh;
    @Column(name="noi_sinh")
    public String noi_sinh;
    @Column(name="que_quan")
    public String que_quan;
    @Column(name="quan_huyen")
    public String quan_huyen;
    @Column(name="tinh_tp")
    public String tinh_tp;
    @Column(name="noi_o_hien_nay")
    public String noi_o_hien_nay;
    @Column(name="so_dien_thoai")
    public String so_dien_thoai;
    @Column(name="dan_toc")
    public String dan_toc;
    @Column(name="ton_giao")
    public String ton_giao;
    @Column(name="thanh_phan_gia_dinh")
    public String thanh_phan_gia_dinh;
    @Column(name="nghe_nghiep_truoc_td")
    public String nghe_nghiep_truoc_td;
    @Column(name="ngay_tuyen_dung")
    public String ngay_tuyen_dung;
    @Column(name="vao_co_quan")
    public String vao_co_quan;
    @Column(name="ngay_vao_co_quan")
    public String ngay_vao_co_quan;
    @Column(name="ngay_tham_gia_cm")
    public String ngay_tham_gia_cm;
    @Column(name="ngay_vao_dang")
    public String ngay_vao_dang;
    @Column(name="ngay_chinh_thuc")
    public String ngay_chinh_thuc;
    @Column(name="ngay_tham_gia_tc")
    public String ngay_tham_gia_tc;
    @Column(name="ngay_nhap_ngu")
    public String ngay_nhap_ngu;
    @Column(name="ngay_xuat_ngu")
    public String ngay_xuat_ngu;
    @Column(name="quan_ham")
    public String quan_ham;
    @Column(name="giao_duc_pt")
    public String giao_duc_pt;
    @Column(name="hoc_ham_hoc_vi")
    public String hoc_ham_hoc_vi;
    @Column(name="ly_luan_chinh_tri")
    public String ly_luan_chinh_tri;
    @Column(name="ngoai_ngu")
    public String ngoai_ngu;
    @Column(name="cong_tac_chinh")
    public String cong_tac_chinh;
    @Column(name="ngach")
    public String ngach;
    @Column(name="ma_so")
    public String ma_so;
    @Column(name="bac_luong")
    public String bac_luong;
    @Column(name="he_so")
    public String he_so;
    @Column(name="tu_thang")
    public String tu_thang;
    @Column(name="danh_hieu_duoc_phong")
    public String danh_hieu_duoc_phong;
    @Column(name="so_truong_cong_tac")
    public String so_truong_cong_tac;
    @Column(name="cong_viec_lau_nam")
    public String cong_viec_lau_nam;
    @Column(name="khen_thuong")
    public String khen_thuong;
    @Column(name="ky_luat")
    public String ky_luat;
    @Column(name="suc_khoe")
    public String suc_khoe;
    @Column(name="cao")
    public String cao;
    @Column(name="can_nang")
    public String can_nang;
    @Column(name="nhom_mau")
    public String nhom_mau;
    @Column(name="so_cmnd")
    public String so_cmnd;
    @Column(name="thuong_binh")
    public String thuong_binh;
    @Column(name="liet_sy")
    public String liet_sy;
    @Column(name="create_dt")
    public Instant createDt;
    @Column(name="create_by")
    public Long createBy;
    @Column(name="update_dt")
    public Instant updateDt;
    @Column(name="update_by")
    public Long updateBy;
    @Column(name = "status")
    public String status;
}
