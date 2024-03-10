package com.fas.repositories;

import com.fas.models.entities.Building;
import com.fas.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {

    @Query("SELECT r FROM Room r WHERE r.code = :code AND r.building.id = :buildingId")
    Room findUniqueNameToAdd(@Param("code") String code, @Param("buildingId") UUID buildingId);

    @Query("SELECT r FROM Room r WHERE r.code = :code AND r.building.id = :buildingId AND r.id != :id")
    Room findUniqueNameToUpdate(@Param("code") String code, @Param("id") UUID id, @Param("buildingId") UUID buildingId);

    @Query("SELECT r FROM Room r WHERE r.building.id = :buildingId")
    List<Room> findRoomByBuilding(@Param("buildingId") UUID buildingId);
}
