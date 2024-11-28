package com.group.samrt.um.domain.uml;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.swing.text.View;

@Data
@Immutable
@Entity(name = "view_transfer_profile_detail")
public class TranferProfileDetail  {
    @Id
    @Column(name = "id")
    public Long id;
    @Column(name="profile_id")
    public Long profile_id;
    @Column(name="type")
    public String type;
    @Column(name="ngay")
    public String ngay;
    @Column(name="co_quan")
    public String co_quan;
    @Column(name="code")
    public String code ;
    @Column(name="fullname")
    public String fullname;
    @Column(name="gender")
    public String gender;
    @Column(name="chuc_vu")
    public String chuc_vu;
    @Column(name="nam_sinh")
    public String nam_sinh;
    @Column(name="status")
    public String status;
}
