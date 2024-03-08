package com.fas.models.dtos.requests;

import com.fas.models.entities.Message;
import lombok.Data;

@Data
public class MessageRequestDTO {
    private String content;

    private String image;

    public Message getMessage() {
        return new Message(content, image);
    }
}
