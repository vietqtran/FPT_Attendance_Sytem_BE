package com.fas.models.dtos.responses;

import com.fas.models.entities.Building;
import com.fas.models.entities.Campus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BuildingResponseDTO {
    private UUID id;

    private String name;

    private Campus campus;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public BuildingResponseDTO(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.campus = building.getCampus();
        this.status = building.isStatus();
        this.createAt = building.getCreateAt();
        this.updateAt = building.getUpdateAt();
    }
}
