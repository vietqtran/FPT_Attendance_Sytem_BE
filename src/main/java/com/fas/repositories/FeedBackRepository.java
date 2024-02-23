package com.fas.repositories;

import com.fas.models.entities.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeedBackRepository extends JpaRepository<FeedBack, UUID> {

}
