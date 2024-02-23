package com.fas.models.dtos.requests;

import com.fas.models.entities.FeedBack;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FeedBackRequestDTO {
    private String studentId;

    private String instructorId;

    private String courseId;

    private String Punctuality;

    private String teachingSkill;

    private String adequatelySyllabus;

    private String Support;

    private String ResponseQuestion;

    private String teachingMethods;

    private String dispositionStudents;

    private String professionalPractices;

    private String appearanceAndPersonal;

    private String overall;

    private String comment;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    public FeedBack getFeedBack() {
        return new FeedBack(
                studentId,
                instructorId,
                courseId,
                Punctuality,
                teachingSkill,
                adequatelySyllabus,
                Support,
                ResponseQuestion,
                teachingMethods,
                dispositionStudents,
                professionalPractices,
                appearanceAndPersonal,
                overall,
                comment,
                createdAt,
                updatedAt
        );
    }
}
