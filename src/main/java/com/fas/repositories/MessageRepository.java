package com.fas.repositories;

import com.fas.models.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, Long> {
    public List<Message> findByChatId(UUID chatId);
}
