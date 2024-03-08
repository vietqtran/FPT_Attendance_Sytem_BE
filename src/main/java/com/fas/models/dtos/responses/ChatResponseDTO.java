package com.fas.models.dtos.responses;

import com.fas.models.entities.Chat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ChatResponseDTO {
    private UUID id;
    private String chatName;
    private String chatImage;

    private List<StudentResponseDTO> students = new ArrayList<>();

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public ChatResponseDTO(Chat chat) {
        this.id = chat.getId();
        this.chatName = chat.getChatName();
        this.chatImage = chat.getChatImage();
        this.students = chat.getStudents().stream().map(StudentResponseDTO::new).toList();
        this.createAt = chat.getCreateAt();
        this.updateAt = chat.getUpdateAt();
    }
}
