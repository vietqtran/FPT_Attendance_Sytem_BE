package com.fas.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class AssignFeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "Instructor is required")
    @ManyToOne
    private Instructor instructor;

    @NotNull(message = "Grade is required")
    @ManyToOne
    private Grade grade;

    @FutureOrPresent(message = "startDate must be in the present or future")
    @NotNull(message = "startDate is required")
    private Date startDate;

    @NotNull(message = "endDate is required")
    @FutureOrPresent(message = "endDate must be in the present or future")
    private Date endDate;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public AssignFeedBack(UUID instructorId,  UUID gradeId, Date startDate, Date endDate, boolean status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.instructor = new Instructor(instructorId);
        this.grade = new Grade(gradeId);
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public AssignFeedBack(UUID assignFeedBackId) {
        this.id = assignFeedBackId;
    }
}
