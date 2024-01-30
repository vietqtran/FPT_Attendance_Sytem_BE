package com.fas.repositories;

import com.fas.models.entities.Instructor;
import com.fas.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {

    Instructor findByEmail(String email);

    @Query("SELECT i FROM Instructor i WHERE i.phone = :phone AND i.id != :id")
    Student findByPhoneUpdate(@Param("phone") String phone, @Param("id") UUID id);

    @Query("SELECT i FROM Instructor i WHERE i.IDCard = :IDCard")
    Student findByIDCard(@Param("IDCard") String IDCard);

    @Query("SELECT i FROM Instructor i WHERE i.IDCard = :IDCard AND i.id != :id")
    Student findByIDCardUpdate(@Param("IDCard") String IDCard, @Param("id") UUID id);
}
