package com.fas.repositories;

import com.fas.models.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {

    @Query("SELECT c FROM Chat c JOIN c.students cu_student JOIN c.students cu_reqStudent WHERE cu_student.id = :studentId AND cu_reqStudent.id = :reqStudentId")
    Chat findChatByStudentsId(UUID studentId, UUID reqStudentId);

    List<Chat> findByStudentsId(UUID studentId);
}
