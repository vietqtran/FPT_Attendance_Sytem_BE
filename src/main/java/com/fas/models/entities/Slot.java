package com.fas.models.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slot {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @NotBlank(message = "Code must not be blank")
    private String name;




    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startAt;


    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endAt;


    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();


    private boolean status = true;


    public Slot(UUID slotId) {
        this.id = slotId;
    }
}
