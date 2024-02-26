package com.fas.models.dtos.requests;

import com.fas.models.entities.FeedBack;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FeedBackRequestDTO {
    private UUID studentId;

    private String Punctuality;

    private String teachingSkill;

    private String adequatelySyllabus;

    private String Support;

    private String ResponseQuestion;

    private String teachingMethods;

    private String dispositionStudents;

    private String overall;

    private String comment;

    private UUID assignFeedBackId;

    private boolean status = true;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    public FeedBack getFeedBack() {
        return new FeedBack(
                studentId,
                Punctuality,
                teachingSkill,
                adequatelySyllabus,
                Support,
                ResponseQuestion,
                teachingMethods,
                dispositionStudents,
                overall,
                comment,
                status,
                assignFeedBackId,
                createdAt,
                updatedAt
        );
    }
}
