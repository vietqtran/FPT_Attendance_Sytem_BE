package com.fas.controllers;

import com.fas.models.dtos.requests.MessageRequestDTO;
import com.fas.models.dtos.responses.MessageResponseDTO;
import com.fas.models.entities.Student;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.MessageService;
import com.fas.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/messages/student/{studentId}/chat/{chatId}")
    private MessageDetails<MessageResponseDTO> createMessage(@RequestBody MessageRequestDTO message, @PathVariable UUID studentId, @PathVariable UUID chatId) {
        Student student = studentService.findStudentById(studentId);

        MessageResponseDTO messageResponseDTO = messageService.createMessage(student, chatId, message);
        if (messageResponseDTO == null) {
            return new MessageDetails<>("Create message failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Create message successfully", messageResponseDTO, Code.SUCCESS);
    }


    @GetMapping("/messages/chat/{chatId}")
    private MessageDetails<List<MessageResponseDTO>> findChatsMessages(@PathVariable UUID chatId) {
        List<MessageResponseDTO> messageResponseDTOS = messageService.findChatsMessages(chatId);
        if (messageResponseDTOS == null) {
            return new MessageDetails<>("Find messages failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Find messages successfully", messageResponseDTOS, Code.SUCCESS);
    }
}
