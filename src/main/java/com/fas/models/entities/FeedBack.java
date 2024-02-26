package com.fas.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @NotNull (message = "StudentId is required")
    private Student student;

    @NotBlank(message = "Punctuality is required")
    private String punctuality;

    @NotBlank(message = "TeachingSkill is required")
    private String teachingSkill;

    @NotBlank(message = "Adequate Syllabus is required")
    private String adequatelySyllabus;

    @NotBlank(message = "InstructorSupport is required")
    private String support;

    @NotBlank(message = "Instructor Response Question is required")
    private String responseQuestion;

    @NotBlank(message = "Teaching Methods is required")
    private String teachingMethods;

    @NotBlank(message = "Disposition Towards Students is required")
    private String dispositionStudents;

    @NotBlank(message = "Overall Rating is required")
    private String overall;

    @NotBlank(message = "Comment is required")
    private String comment;

    private boolean status = true;

    @NotNull(message = "createdAt is required")
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull(message = "updatedAt is required")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne
    private AssignFeedBack assignFeedBack;


    public FeedBack(UUID studentId, String punctuality, String teachingSkill, String adequatelySyllabus, String support, String responseQuestion, String teachingMethods, String dispositionStudents, String overall, String comment, boolean status, UUID assignFeedBackId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.student = new Student(studentId);
        this.punctuality = punctuality;
        this.teachingSkill = teachingSkill;
        this.adequatelySyllabus = adequatelySyllabus;
        this.support = support;
        this.responseQuestion = responseQuestion;
        this.teachingMethods = teachingMethods;
        this.dispositionStudents = dispositionStudents;
        this.overall = overall;
        this.comment = comment;
        this.status = status;
        this.assignFeedBack = new AssignFeedBack(assignFeedBackId);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
