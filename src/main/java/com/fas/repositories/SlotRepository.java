package com.fas.repositories;

import com.fas.models.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SlotRepository extends JpaRepository<Slot, UUID> {

    Slot findByName(String name);

    @Query("SELECT s FROM Slot s WHERE s.name = :name AND s.id != :excludeSlotId")
    Slot findUniqueNameToUpdate(@Param("name") String name, @Param("excludeSlotId") UUID slotId);

}
