package com.fas.repositories;

import com.fas.models.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AssignFeedBackRepository extends JpaRepository<AssignFeedBack, UUID> {

    @Query("SELECT m FROM AssignFeedBack m WHERE m.instructor.id = :instructorId AND m.grade.id = :gradeId")
    AssignFeedBack findAssignFeedBackByInstructorAndGrade(Instructor instructor, Grade grade);

    @Query("SELECT m FROM AssignFeedBack m WHERE m.instructor.id = :instructorId AND m.grade.id = :gradeId AND m.id != :id")
    AssignFeedBack findAssignFeedBackByInstructorAndGradeUnique(@Param("instructorId") UUID instructorId, @Param("id") UUID id, @Param("gradeId") UUID gradeId);
}
