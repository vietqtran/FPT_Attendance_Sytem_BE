package com.fas.models.dtos.requests;


import com.fas.models.entities.Slot;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;


@Data
public class SlotRequestDTO {


    private UUID id;


    private String name;


    private LocalTime startAt;


    private LocalTime endAt;


    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private boolean status = true;


    public Slot getSlot(){
        return new Slot(id, name, startAt, endAt, createdAt, updatedAt, status);
    }
}
