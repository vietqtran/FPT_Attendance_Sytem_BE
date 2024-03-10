package com.fas.repositories;

import com.fas.models.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.UUID;

public interface SlotRepository extends JpaRepository<Slot, UUID> {

    Slot findByName(String name);

    @Query("SELECT s FROM Slot s WHERE s.name = :name AND s.id != :excludeSlotId")
    Slot findUniqueNameToUpdate(@Param("name") String name, @Param("excludeSlotId") UUID slotId);

    @Query("SELECT COUNT(s) > 0 FROM Slot s " +
            "WHERE ((s.startAt >= :startAt AND s.startAt < :endAt) " +
            "OR (s.endAt > :startAt AND s.endAt <= :endAt) " +
            "OR (s.startAt <= :startAt AND s.endAt >= :endAt))")
    boolean existsByTimeRangeOverlap(LocalTime startAt, LocalTime endAt);

    @Query("SELECT COUNT(s) > 0 FROM Slot s " +
            "WHERE s.id <> :slotId AND ((s.startAt >= :startAt AND s.startAt < :endAt) " +
            "OR (s.endAt > :startAt AND s.endAt <= :endAt) " +
            "OR (s.startAt <= :startAt AND s.endAt >= :endAt))")
    boolean existsByTimeRangeOverlapExcludingSlot(@Param("slotId") UUID slotId, @Param("startAt") LocalTime startAt, @Param("endAt") LocalTime endAt);
}
