package com.fas.models.dtos.requests;

import com.fas.models.entities.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class ActivityRequestDTO {
    private UUID id;

    private LocalDate date;

    private UUID roomId;

    private UUID slotId;

    private UUID assignId;

    private UUID instructorId;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();


    public Activity getActivity(){
        return new Activity(id, date, roomId, slotId, assignId, instructorId, status, createAt, updateAt);
    }
}
