package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tranfer_profile")
public class TranferProfile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="profile_id")
    public Long profile_id;
    @Column(name="status")
    public String status;
    @Column(name="ngay")
    public String ngay;
    @Column(name="co_quan")
    public String co_quan;
    @Column(name="type")
    public String type;
}
