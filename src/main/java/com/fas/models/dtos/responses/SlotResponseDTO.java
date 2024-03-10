package com.fas.models.dtos.responses;


import com.fas.models.entities.Slot;
import lombok.Data;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;


@Data
public class SlotResponseDTO {


    private UUID id;
    private String name;


    private LocalTime startAt;


    private LocalTime endAt;


    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();


    private boolean status = true;


    public SlotResponseDTO(Slot slot) {
        this.id = slot.getId();
        this.name = slot.getName();
        this.startAt = slot.getStartAt();
        this.endAt = slot.getEndAt();
        this.createdAt = slot.getCreatedAt();
        this.updatedAt = slot.getUpdatedAt();
        this.status = slot.isStatus();
    }
}
