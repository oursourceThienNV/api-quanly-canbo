package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@Table(name="view_thong_ke_profile")
public class ViewThongKeProfile {
    @Id
    @Column(name="nam_sinh")
    private Long namSinh;
    @Column(name="tong_so_luong")
    private Long tong_so_luong;
    @Column(name="so_nam")
    private Long so_nam;
    @Column(name="so_nu")
    private Long so_nu;
    @Column(name="so_kinh")
    private Long so_kinh;
    @Column(name="so_khmer")
    private Long so_khmer;
    @Column(name="so_hoa")
    private Long so_hoa;
    @Column(name="so_cham")
    private Long so_cham;
    @Column(name="so_khac")
    private Long so_khac;
}
