package com.fas.services;

import com.fas.models.dtos.requests.MessageRequestDTO;
import com.fas.models.dtos.responses.MessageResponseDTO;
import com.fas.models.entities.Student;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    MessageResponseDTO createMessage(Student student, UUID chatId, MessageRequestDTO message);

    List<MessageResponseDTO> findChatsMessages(UUID chatId);

    MessageResponseDTO deleteMessage(Long messageId);
}
