package com.fas.models.dtos.responses;

import com.fas.models.entities.Course;
import com.fas.models.entities.Student;
import com.fas.models.entities.Term;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class TermResponseDTO {
    private UUID id;

    private String name;


    private Date startAt;

    private Date endAt;

    private boolean status = true;
    private List<GradeResponseDTO> grades = new ArrayList<>();

    private List<StudentResponseDTO> students = new ArrayList<>();

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    public TermResponseDTO (Term term) {
        this.id = term.getId();
        this.name = term.getName();
        this.startAt = term.getStartAt();
        this.endAt = term.getEndAt();
        this.status = term.isStatus();
        this.grades = term.getGrades().stream().map(GradeResponseDTO::new).toList();
        this.students = term.getStudents().stream().map(StudentResponseDTO::new).toList();
        this.createAt = term.getCreateAt();
        this.updateAt = term.getUpdateAt();
    }
}
