package com.fas.repositories;

import com.fas.models.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GradeRepository extends JpaRepository<Grade, UUID> {
    Grade findByCode(String code);

    List<Grade> findGradesByCoursesContaining(Course course);

    List<Grade> findGradeByMajor(Major major);

    @Query("SELECT m FROM Grade m WHERE m.code = :code AND m.campus.id = :campusId")
    Grade findUniqueCodeToAdd(@Param("code") String code, @Param("campusId") Long campusId);
    @Query("SELECT m FROM Grade m WHERE m.code = :code AND m.campus.id = :campusId AND m.id != :id")
    Grade findUniqueCodeToUpdate(@Param("code") String code, @Param("id") UUID id, @Param("campusId") Long campusId);

    @Query("SELECT g FROM Grade g WHERE :course MEMBER OF g.courses AND :term MEMBER OF g.terms")
    List<Grade> findGradesByCoursesAndTerms(@Param("course") Course course, @Param("term") Term term);

    List<Grade> findGradesByStudentsContains(Student student);
}
