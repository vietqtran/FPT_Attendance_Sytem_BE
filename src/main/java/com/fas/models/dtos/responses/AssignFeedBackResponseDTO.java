package com.fas.models.dtos.responses;

import com.fas.models.entities.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class AssignFeedBackResponseDTO {

    private UUID id;
    private Instructor instructor;
    private Grade grade;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private List<FeedBack> feedBacks;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public AssignFeedBackResponseDTO (AssignFeedBack assignFeedBack) {
        this.id = assignFeedBack.getId();
        this.instructor = assignFeedBack.getInstructor();
        this.grade = assignFeedBack.getGrade();
        this.startDate = assignFeedBack.getStartDate();
        this.endDate = assignFeedBack.getEndDate();
        this.status = assignFeedBack.isStatus();
        this.createAt = assignFeedBack.getCreateAt();
        this.updateAt = assignFeedBack.getUpdateAt();
        this.feedBacks = assignFeedBack.getFeedBacks();
    }
}
