package com.fas.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String chatName;

    private String chatImage;

    @ManyToMany
    @JoinTable(name = "chat_student", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "chat")
    @JsonIgnore
    private List<Message> messages = new ArrayList<>();

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    public Chat(UUID id, String chatName, String chatImage) {
        this.id = id;
        this.chatName = chatName;
        this.chatImage = chatImage;
    }
}
