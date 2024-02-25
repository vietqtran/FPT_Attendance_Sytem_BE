package com.fas.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    @NotNull(message = "Start date must not be blank")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private Date startAt;

    @NotNull(message = "End date must not be blank")
    @FutureOrPresent(message = "End date must be in the present or future")
    private Date endAt;

    private boolean status = true;

    @ManyToMany(mappedBy = "terms")
    private List<Grade> grades = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "student_term", joinColumns = @JoinColumn(name = "term_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();
}
