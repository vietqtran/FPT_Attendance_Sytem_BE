package com.fas.services.implementation;

import com.fas.models.dtos.requests.MessageRequestDTO;
import com.fas.models.dtos.responses.MessageResponseDTO;
import com.fas.models.entities.Chat;
import com.fas.models.entities.Message;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.MessageExceptions;
import com.fas.repositories.ChatRepository;
import com.fas.repositories.MessageRepository;
import com.fas.services.ChatService;
import com.fas.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImplementation implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatRepository chatRepository;
    @Override
    public MessageResponseDTO createMessage(Student student, UUID chatId, MessageRequestDTO messageRequestDTO) {
        Chat chat = chatService.findChatById(chatId);
        Message message = messageRequestDTO.getMessage();

        Message newMessage = new Message();
        newMessage.setContent(message.getContent());
        newMessage.setImage(message.getImage());
        newMessage.setChat(chat);
        newMessage.setStudent(student);

        chat.getMessages().add(newMessage);
        chatRepository.save(chat);

        return new MessageResponseDTO(messageRepository.save(newMessage));
    }

    @Override
    public List<MessageResponseDTO> findChatsMessages(UUID chatId) {
        Chat chat = chatService.findChatById(chatId);

        return chat.getMessages().stream().map(MessageResponseDTO::new).toList();
    }

    @Override
    public MessageResponseDTO deleteMessage(Long messageId) {
        Message message = messageRepository.findById(messageId).orElseThrow(() -> new MessageExceptions("Message not found"));
        message.setStatus(false);
        message.setUpdateAt(LocalDateTime.now());

        return new MessageResponseDTO(messageRepository.save(message));
    }
}
