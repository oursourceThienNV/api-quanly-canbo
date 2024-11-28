package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "qua_trinh")
public class QuaTrinh {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="profile_id")
    public Long profileId;
    @Column(name="value_1")
    public String value_1;
    @Column(name="value_2")
    public String value_2;
    @Column(name="value_3")
    public String value_3;
    @Column(name="value_4")
    public String value_4;
    @Column(name="value_5")
    public String value_5;
    @Column(name="value_6")
    public String value_6;
    @Column(name="value_7")
    public String value_7;
    @Column(name="value_8")
    public String value_8;
    @Column(name="loai_qt")
    public String loai_qt;
}
