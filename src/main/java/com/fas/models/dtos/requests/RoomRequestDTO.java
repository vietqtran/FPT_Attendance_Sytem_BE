package com.fas.models.dtos.requests;


import com.fas.models.entities.Building;
import com.fas.models.entities.Room;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class RoomRequestDTO {


    private UUID id;


    private String code;


    private UUID buildingId;


    private boolean status = true;


    private LocalDateTime createAt = LocalDateTime.now();


    private LocalDateTime updateAt = LocalDateTime.now();


    public Room getRoom(){
        return new Room(id, code, buildingId, status, createAt, updateAt);
    }
}
