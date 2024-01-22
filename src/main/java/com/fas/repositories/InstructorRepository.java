package com.fas.repositories;

import com.fas.models.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {

    Instructor findByEmail(String email);

}
