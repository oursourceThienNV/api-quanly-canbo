package com.group.samrt.um.client.client.response.uml;

import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.domain.dto.uml.ProfileDTO;
import com.group.samrt.um.domain.uml.TranferProfile;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TranferProfileResponse {
    private OptimizedPage<TranferProfile> page;

    public TranferProfileResponse() {

    }
}
