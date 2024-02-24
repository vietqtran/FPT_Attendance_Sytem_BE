package com.fas.models.dtos.requests;

import com.fas.models.entities.Course;
import com.fas.models.entities.Student;
import com.fas.models.entities.Term;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TermRequestDTO {

    private UUID id;

    private String name;


    private Date startAt;

    private Date endAt;

    private boolean status = true;
    private List<Course> courses = new ArrayList<>();

    private List<Student> students = new ArrayList<>();

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();
    public Term getTerm() {
        return new Term(id, name, startAt, endAt,status, courses, students ,createAt, updateAt);
    }
}
