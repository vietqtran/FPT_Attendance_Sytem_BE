package com.fas.models.dtos.responses;

import com.fas.models.entities.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class ActivityResponseDTO {
    private UUID id;

    private LocalDate date;

    private Room room;


    private Slot slot;

    private Assign assign;

    private Instructor instructor;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    private List<Attendance> attendances = new ArrayList<>();

    public ActivityResponseDTO(Activity activity) {
        this.id = activity.getId();
        this.createAt = activity.getCreateAt();
        this.updateAt = activity.getUpdateAt();
        this.date = activity.getDate();
        this.status = activity.isStatus();
        this.room = activity.getRoom();
        this.slot = activity.getSlot();
        this.assign = activity.getAssign();
        this.instructor = activity.getInstructor();
        this.attendances = activity.getAttendances();
    }
}
