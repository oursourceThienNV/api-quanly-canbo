package com.group.samrt.um.domain.dto.uml;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class ViewThongKeProfileDTO {
    private Long tong;
    private Long so_nam;
    private Long so_nu;
    private Long so_kinh;
    private Long so_khmer;
    private Long so_hoa;
    private Long so_cham;
    private Long so_khac;
}

