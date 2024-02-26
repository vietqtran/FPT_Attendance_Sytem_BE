package com.fas.models.dtos.responses;

import com.fas.models.entities.AssignFeedBack;
import com.fas.models.entities.FeedBack;
import com.fas.models.entities.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FeedBackResponseDTO {

    private UUID id;

    private Student student;

    private String Punctuality;

    private String teachingSkill;

    private String adequatelySyllabus;

    private String Support;

    private String ResponseQuestion;

    private String teachingMethods;

    private String dispositionStudents;

    private String overall;

    private String comment;

    private AssignFeedBack assignFeedBack;

    private boolean status = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    public FeedBackResponseDTO (FeedBack feedBack) {
        this.id = feedBack.getId();
        this.student = feedBack.getStudent();
        this.Punctuality = feedBack.getPunctuality();
        this.teachingSkill = feedBack.getTeachingSkill();
        this.adequatelySyllabus = feedBack.getAdequatelySyllabus();
        this.Support = feedBack.getSupport();
        this.ResponseQuestion = feedBack.getResponseQuestion();
        this.teachingMethods = feedBack.getTeachingMethods();
        this.dispositionStudents = feedBack.getDispositionStudents();
        this.overall = feedBack.getOverall();
        this.comment = feedBack.getComment();
        this.assignFeedBack = feedBack.getAssignFeedBack();
        this.status = feedBack.isStatus();
        this.createdAt = feedBack.getCreatedAt();
        this.updatedAt = feedBack.getUpdatedAt();
    }
}
