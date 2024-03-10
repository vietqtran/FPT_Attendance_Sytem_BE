package com.fas.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull(message = "Date must not be null")
    private LocalDate date;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Slot slot;

    @ManyToOne
    private Assign assign;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    @OneToMany
    private List<Attendance> attendances = new ArrayList<>();

    public Activity(UUID id, LocalDate date, UUID roomId, UUID slotId, UUID assignId, UUID instructorId, boolean status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.date = date;
        this.status = status;
        this.room = new Room(roomId);
        this.slot = new Slot(slotId);
        this.assign = new Assign(assignId);
        this.instructor = new Instructor(instructorId);
    }
}
