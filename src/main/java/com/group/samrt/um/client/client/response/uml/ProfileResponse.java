package com.group.samrt.um.client.client.response.uml;

import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.domain.dto.uml.ProfileDTO;
import com.group.samrt.um.domain.dto.uml.UserDetailDTO;
import com.group.samrt.um.domain.uml.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileResponse {
    private OptimizedPage<ProfileDTO> page;

    public ProfileResponse() {

    }
}
