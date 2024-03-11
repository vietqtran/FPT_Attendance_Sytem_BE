package com.fas.services.implementation;

import com.fas.models.dtos.responses.ChatResponseDTO;
import com.fas.models.entities.Chat;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.ChatExceptions;
import com.fas.repositories.ChatRepository;
import com.fas.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatServiceImplementation implements ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Override
    public ChatResponseDTO createChat(Student reqStudent, Student student) {
        Chat existedChat = chatRepository.findChatByStudentsId(student.getId(), reqStudent.getId());
        if(existedChat != null) {
            return new ChatResponseDTO(existedChat);
        }

        Chat newChat = new Chat();
        newChat.getStudents().add(reqStudent);
        newChat.getStudents().add(student);

        return new ChatResponseDTO(chatRepository.save(newChat));
    }

    @Override
    public Chat findChatById(UUID chatId) {
        Optional<Chat> chat = chatRepository.findById(chatId);
        if(chat.isEmpty()) {
            throw new ChatExceptions("Chat not found");
        }
        return chat.get();
    }

    @Override
    public List<ChatResponseDTO> findStudentChat(UUID studentId, String query) {
        List<Chat> chats = chatRepository.findByStudentsId(studentId);

        if(query != null && !query.isEmpty()) {
            chats = chatRepository.searchStudentChats(query);
        }

        List<ChatResponseDTO> chatResponseDTOS = new ArrayList<>();
        for (Chat chat : chats) {
            chatResponseDTOS.add(new ChatResponseDTO(chat));
        }

        return chatResponseDTOS;
    }
}
