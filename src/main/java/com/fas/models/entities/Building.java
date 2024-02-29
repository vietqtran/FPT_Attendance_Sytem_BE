package com.fas.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @ManyToOne
    private Campus campus;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Building(UUID id, String name, Long campusId, boolean status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.campus = new Campus(campusId);
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
