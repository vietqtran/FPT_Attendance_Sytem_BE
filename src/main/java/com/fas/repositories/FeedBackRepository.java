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

    @Query("SELECT fb FROM FeedBack fb WHERE fb.student.id = :studentId AND fb.assignFeedBack.id = :assignFeedBackId")
    FeedBack getFeedBackByStudentIdAndAssignFeedBack(UUID studentId, UUID assignFeedBackId);
}
