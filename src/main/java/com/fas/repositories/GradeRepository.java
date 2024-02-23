package com.fas.repositories;

import com.fas.models.entities.Course;
import com.fas.models.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GradeRepository extends JpaRepository<Grade, UUID> {
    Grade findByCode(String code);

    List<Grade> findGradesByCoursesContaining(Course course);
}
