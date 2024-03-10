package com.fas.models.dtos.requests;

import com.fas.models.entities.Course;
import com.fas.models.entities.Grade;
import com.fas.models.entities.Student;
import com.fas.models.entities.Term;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class TermRequestDTO {

    private UUID id;

    private String name;


    private LocalDate startAt;

    private LocalDate endAt;

    private boolean status = true;
    private List<Grade> grades = new ArrayList<>();

    private List<Student> students = new ArrayList<>();

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();
    public Term getTerm() {
        return new Term(id, name, startAt, endAt,status, grades, students ,createAt, updateAt);
    }
}
