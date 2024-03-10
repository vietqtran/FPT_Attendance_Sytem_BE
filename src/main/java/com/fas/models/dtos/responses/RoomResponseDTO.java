package com.fas.models.dtos.responses;


import com.fas.models.entities.Building;
import com.fas.models.entities.Room;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class RoomResponseDTO {
    private UUID id;


    private String code;


    private Building building;


    private boolean status = true;


    private LocalDateTime createAt = LocalDateTime.now();


    private LocalDateTime updateAt = LocalDateTime.now();


    public RoomResponseDTO(Room room) {
        this.id = room.getId();
        this.code = room.getCode();
        this.building = room.getBuilding();
        this.status = room.isStatus();
        this.createAt = room.getCreateAt();
        this.updateAt = room.getUpdateAt();
    }
}
