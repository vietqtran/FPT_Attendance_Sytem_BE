package com.fas.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
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

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

}
