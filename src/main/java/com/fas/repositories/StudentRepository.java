package com.fas.repositories;

import com.fas.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    Student findByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.phone = :phone")
    Student findByPhone(@Param("phone") String phone);

    @Query("SELECT s FROM Student s WHERE s.phone = :phone AND s.id != :id")
    Student findByPhoneUpdate(@Param("phone") String phone, @Param("id") UUID id);

    @Query("SELECT s FROM Student s WHERE s.idCard = :IDCard")
    Student findByIDCard(@Param("IDCard") String IDCard);

    @Query("SELECT s FROM Student s WHERE s.idCard = :IDCard AND s.id != :id")
    Student findByIDCardUpdate(@Param("IDCard") String IDCard, @Param("id") UUID id);

    @Query("SELECT s FROM Student s JOIN s.grades g JOIN s.courses c " +
            "WHERE g.id = :gradeId AND c.id = :courseId " +
            "AND (:majorId IS NULL OR s.major.id = :majorId) " +
            "AND (:searchValue IS NULL OR " +
            "(LOWER(s.firstName) LIKE LOWER(CONCAT('%', :searchValue, '%')) " +
            "OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :searchValue, '%')) " +
            "OR LOWER(s.middleName) LIKE LOWER(CONCAT('%', :searchValue, '%')) " +
            "OR LOWER(s.studentCode) LIKE LOWER(CONCAT('%', :searchValue, '%')))) " +
            "ORDER BY CASE WHEN :order = 'ASC' THEN s.studentCode END ASC, " +
            "CASE WHEN :order = 'DESC' THEN s.studentCode END DESC")
    List<Student> filterAndSortStudents(
            @Param("gradeId") UUID gradeId,
            @Param("courseId") UUID courseId,
            @Param("majorId") UUID majorId,
            @Param("searchValue") String searchValue,
            @Param("order") String order
    );


    @Query("SELECT s FROM Student s " +
            "WHERE s.firstName LIKE %:searchValue% " +
            "OR s.lastName LIKE %:searchValue% " +
            "OR s.middleName LIKE %:searchValue% " +
            "OR s.studentCode LIKE %:searchValue%")
    List<Student> searchStudents(@Param("searchValue") String searchValue);
}
