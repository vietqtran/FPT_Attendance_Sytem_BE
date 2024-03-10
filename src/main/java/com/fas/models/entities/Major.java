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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Code must not be blank")
    private String code;

    @NotBlank(message = "Name must not be blank")
    private String name;

    private boolean status = true;

    @ManyToMany
    @JoinTable(name = "course_major", joinColumns = @JoinColumn(name = "major_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Major(UUID majorId) {
        this.id = majorId;
    }

    public Major(UUID id, String code, String name, boolean status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
