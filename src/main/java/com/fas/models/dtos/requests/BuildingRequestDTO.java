package com.fas.models.dtos.requests;

import com.fas.models.entities.Building;
import com.fas.models.entities.Campus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BuildingRequestDTO {
    private UUID id;

    private String name;

    private Long campusId;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();


    public Building getBuilding() {
        return new Building(id, name, campusId, status , createAt, updateAt);
    }
}
