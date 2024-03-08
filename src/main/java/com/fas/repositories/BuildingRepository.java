package com.fas.repositories;

import com.fas.models.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {

    @Query("SELECT m FROM Building m WHERE m.name = :name AND m.campus.id = :campusId")
    Building findUniqueNameToAdd(@Param("name") String name, @Param("campusId") Long campusId);

    @Query("SELECT m FROM Building m WHERE m.name = :name AND m.campus.id = :campusId AND m.id != :id")
    Building findUniqueNameToUpdate(@Param("name") String name, @Param("id") UUID id, @Param("campusId") Long campusId);


    @Query("SELECT g FROM Building g WHERE g.campus.id = :campusId")
    List<Building> findBuildingByCampus(@Param("campusId") Long campusId);
}
