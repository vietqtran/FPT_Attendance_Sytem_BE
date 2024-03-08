package com.fas.models.dtos.responses;

import com.fas.models.entities.Chat;
import com.fas.models.entities.Message;
import com.fas.models.entities.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageResponseDTO {
    private String content;

    private String image;

    private UUID studentId;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public MessageResponseDTO(Message message) {
        this.content = message.getContent();
        this.image = message.getImage();
        this.studentId = message.getStudent().getId();
        this.createAt = message.getCreateAt();
        this.updateAt = message.getUpdateAt();
    }
}
