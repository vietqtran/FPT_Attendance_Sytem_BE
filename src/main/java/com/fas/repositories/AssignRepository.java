package com.fas.repositories;

import com.fas.models.entities.Assign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssignRepository extends JpaRepository<Assign, UUID> {
}
