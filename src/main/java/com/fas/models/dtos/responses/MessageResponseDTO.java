package com.fas.models.dtos.responses;

import com.fas.models.entities.Chat;
import com.fas.models.entities.Message;
import com.fas.models.entities.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageResponseDTO {
    private Long id;
    private String content;

    private String image;

    private UUID studentId;

    private boolean status;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public MessageResponseDTO(Message message) {
        this.id = message.getId();
        this.content = message.getContent();
        this.image = message.getImage();
        this.studentId = message.getStudent().getId();
        this.status = message.isStatus();
        this.createAt = message.getCreateAt();
        this.updateAt = message.getUpdateAt();
    }
}
