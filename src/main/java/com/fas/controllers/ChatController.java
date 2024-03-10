package com.fas.controllers;

import com.fas.models.dtos.responses.ChatResponseDTO;
import com.fas.models.entities.Student;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.ChatService;
import com.fas.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/chats/{reqStudentId}/{studentId}")
    private MessageDetails<ChatResponseDTO> createChat(@PathVariable UUID reqStudentId, @PathVariable UUID studentId) {
        Student reqStudent = studentService.findStudentById(reqStudentId);
        Student student = studentService.findStudentById(studentId);

        ChatResponseDTO chat = chatService.createChat(reqStudent, student);
        if(chat == null) {
            return new MessageDetails<>("Chat created failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Chat created successfully", chat, Code.SUCCESS);
    }

    @GetMapping("/chats/student/{studentId}")
    private MessageDetails<List<ChatResponseDTO>> findStudentChat(@PathVariable UUID studentId,
                                                                  @RequestParam(required = false) String query) {
        List<ChatResponseDTO> chats = chatService.findStudentChat(studentId, query);
        if(chats == null) {
            return new MessageDetails<>("Chat not found", null, Code.FAILURE);
        }
        return new MessageDetails<>("Chat found successfully", chats, Code.SUCCESS);
    }
}
