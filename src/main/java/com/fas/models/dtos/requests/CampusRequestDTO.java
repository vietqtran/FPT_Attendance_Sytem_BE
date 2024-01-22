package com.fas.models.dtos.requests;

import com.fas.models.entities.Campus;
import com.fas.models.enums.CampusName;
import lombok.Data;

@Data
public class CampusRequestDTO {

    private Long id;

    private CampusName name;

    public Campus getCampus() {
        return new Campus(id, name);
    }
}
