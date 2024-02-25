package com.fas.models.dtos.responses;

import com.fas.models.entities.AssignFeedBack;
import com.fas.models.entities.Course;
import com.fas.models.entities.Grade;
import com.fas.models.entities.Instructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class AssignFeedBackResponseDTO {

    private UUID id;
    private Instructor instructorId;
    private Grade gradeId;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public AssignFeedBackResponseDTO (AssignFeedBack assignFeedBack) {
        this.id = assignFeedBack.getId();
        this.instructorId = assignFeedBack.getInstructor();
        this.gradeId = assignFeedBack.getGrade();
        this.startDate = assignFeedBack.getStartDate();
        this.endDate = assignFeedBack.getEndDate();
        this.status = assignFeedBack.isStatus();
        this.createAt = assignFeedBack.getCreateAt();
        this.updateAt = assignFeedBack.getUpdateAt();
    }
}
