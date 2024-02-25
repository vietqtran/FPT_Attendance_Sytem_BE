package com.fas.models.dtos.requests;


import com.fas.models.entities.AssignFeedBack;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class AssignFeedBackRequestDTO {

    private UUID instructorId;

    private UUID gradeId;

    private Date startDate;

    private Date endDate;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public AssignFeedBack getAssignFeedBack() {
        return new AssignFeedBack(instructorId, gradeId, startDate, endDate, status, createAt, updateAt);
    }
}
