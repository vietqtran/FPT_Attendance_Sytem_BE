package com.fas.services;

import com.fas.models.dtos.responses.ChatResponseDTO;
import com.fas.models.entities.Chat;
import com.fas.models.entities.Student;

import java.util.List;
import java.util.UUID;

public interface ChatService {
    public ChatResponseDTO createChat(Student reqStudent, Student student);

    public Chat findChatById(UUID chatId);

    public List<ChatResponseDTO> findStudentChat(UUID studentId);
}
