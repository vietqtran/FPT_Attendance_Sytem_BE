package com.fas.repositories;

import com.fas.models.entities.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface TermRepository extends JpaRepository<Term, UUID> {
    Term findTermByName(String name);
    @Query("SELECT m FROM Term m WHERE m.name = :name AND m.id != :id")
    Term checkUniqueTermName(@Param("name") String name, @Param("id") UUID id);
}
