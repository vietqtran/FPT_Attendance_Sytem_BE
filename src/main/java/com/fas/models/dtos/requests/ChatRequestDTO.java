package com.fas.models.dtos.requests;

import com.fas.models.entities.Chat;
import lombok.Data;

import java.util.UUID;

@Data
public class ChatRequestDTO {
    private UUID id;

    private String chatName;

    private String chatImage;

    public Chat ChatRequestDTO() {
        return new Chat(id, chatName, chatImage);
    }
}
