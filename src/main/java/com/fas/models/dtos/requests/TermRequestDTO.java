package com.fas.models.dtos.requests;

import com.fas.models.entities.Term;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class TermRequestDTO {
    private UUID id;

    private String name;

    private Date startAt;

    private Date endAt;

    private boolean status = true;
    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Term getTerm() {
        return new Term(id, name, startAt, endAt,status ,createAt, updateAt);
    }
}
