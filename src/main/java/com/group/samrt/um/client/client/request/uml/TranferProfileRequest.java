package com.group.samrt.um.client.client.request.uml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranferProfileRequest {
    private Long id;
    private Long profile_id;
    private String ngay;
    private String co_quan;
    private String type;
    private String status;
}
