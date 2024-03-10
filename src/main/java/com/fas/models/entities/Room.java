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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @NotBlank(message = "Code must not be blank")
    private String code;


    @ManyToOne
    private Building building;


    private boolean status = true;


    private LocalDateTime createAt = LocalDateTime.now();


    private LocalDateTime updateAt = LocalDateTime.now();


    public Room(UUID roomId) {
        this.id = roomId;
    }


    public Room(UUID id, String code, UUID buildingId, boolean status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.code = code;
        this.building = new Building(buildingId);
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
