package com.fas.repositories;

import com.fas.models.entities.AssignFeedBack;
import com.fas.models.entities.FeedBack;
import com.fas.models.entities.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FeedBackRepository extends JpaRepository<FeedBack, UUID> {

    @Query("SELECT m FROM FeedBack m WHERE m.assignFeedBack.id = :assignCode AND m.studentId = :id")
    FeedBack checkFeedBack(@Param("assignCode") UUID assignCode, @Param("id") UUID id);
}
