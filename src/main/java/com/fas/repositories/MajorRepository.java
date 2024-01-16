package com.fas.repositories;

import com.fas.models.entities.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MajorRepository extends JpaRepository<Major, UUID> {
    Major findByCode(String code);
}
