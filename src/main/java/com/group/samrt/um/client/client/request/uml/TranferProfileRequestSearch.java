package com.group.samrt.um.client.client.request.uml;

import io.github.jhipster.service.filter.StringFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranferProfileRequestSearch {
    private int pageNumber;
    private int pageSize;
    private StringFilter code;
    private StringFilter fullname;
    private StringFilter status;
    private StringFilter type;
}
