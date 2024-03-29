package com.fas.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Class code is required")
    private String code;

    private boolean status = true;

    @ManyToOne
    @JsonIgnore
    private Campus campus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToMany
    @JoinTable(name="grade_student", joinColumns = @JoinColumn(name = "grade_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "grades")
    @JsonIgnore
    private List<Course> courses = new ArrayList<> ();

    @ManyToMany
    @JoinTable(name="grade_term", joinColumns = @JoinColumn(name = "grade_id"), inverseJoinColumns = @JoinColumn(name = "term_id"))
    @JsonIgnore
    private List<Term> terms = new ArrayList<> ();

    @OneToMany(mappedBy = "grade")
    private List<Assign> assigns = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    public Grade(UUID id, String code, boolean status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Grade(UUID id, String code, boolean status, LocalDateTime createdAt, LocalDateTime updatedAt, UUID majorId, Long campusId) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.major = new Major(majorId);
        this.campus = new Campus(campusId);
    }

    public Grade(UUID gradeId) {
        this.id = gradeId;
    }
}