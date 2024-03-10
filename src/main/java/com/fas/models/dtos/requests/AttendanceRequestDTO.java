package com.fas.models.dtos.requests;


import com.fas.models.entities.Attendance;
import com.fas.models.entities.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AttendanceRequestDTO {

    private UUID id;

    private boolean status = false;

    private UUID studentId;

    private String content;

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    public Attendance getAttendance() {
        return new Attendance(status, new Student(studentId), content, createAt, updateAt);
    }
}
