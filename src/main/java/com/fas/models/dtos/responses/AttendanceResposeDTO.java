package com.fas.models.dtos.responses;

import com.fas.models.entities.Attendance;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class AttendanceResposeDTO {

    private UUID id;

    private boolean status = false;

    private UUID studentId;

    private String content;

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    public AttendanceResposeDTO(Attendance attendance) {
        this.id = attendance.getId();
        this.status = attendance.isStatus();
        this.studentId = attendance.getStudent().getId();
        this.content = attendance.getContent();
        this.createAt = attendance.getCreateAt();
        this.updateAt = attendance.getUpdateAt();
    }
}
