package com.fas.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotNull(message = "Start Date must not be null")
    @FutureOrPresent(message = "Start Date must be in the present or future")
    private Date startAt;

    @NotNull(message = "End date must not be null")
    @FutureOrPresent(message = "End Date must be in the present or future")
    private Date endAt;

    private boolean status = true;

    @ManyToMany
    @JoinTable(name = "course_term", joinColumns = @JoinColumn(name = "term_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "student_term", joinColumns = @JoinColumn(name = "term_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    public Term(UUID id, String name, Date startAt, Date endAt, boolean status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
