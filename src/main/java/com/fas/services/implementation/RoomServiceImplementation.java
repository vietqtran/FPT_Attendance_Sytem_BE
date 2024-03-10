package com.fas.services.implementation;


import com.fas.models.dtos.requests.RoomRequestDTO;
import com.fas.models.dtos.responses.BuildingResponseDTO;
import com.fas.models.dtos.responses.RoomResponseDTO;
import com.fas.models.entities.Building;
import com.fas.models.entities.Room;
import com.fas.models.exceptions.BuildingExceptions;
import com.fas.models.exceptions.GradeExceptions;
import com.fas.models.exceptions.RoomExceptions;
import com.fas.repositories.RoomRepository;
import com.fas.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class RoomServiceImplementation implements RoomService {


    @Autowired
    private RoomRepository roomRepository;


    @Override
    public RoomResponseDTO createRoom(RoomRequestDTO roomRequestDTO) {
        Room room = roomRequestDTO.getRoom();
        Room checkRoom = roomRepository.findUniqueNameToAdd(room.getCode(), room.getBuilding().getId());
        if (checkRoom != null) {
            throw new RoomExceptions("Room already exists");
        }
        Room newRoom = roomRepository.save(room);
        return new RoomResponseDTO(newRoom);
    }


    @Override
    public RoomResponseDTO updateRoom(UUID id, RoomRequestDTO roomRequestDTO) {
        Room existedRoom = roomRepository.findById(id).get();
        if (existedRoom == null) {
            throw new BuildingExceptions("Room not found");
        }
        Room newRoom = roomRequestDTO.getRoom();
        Room checkRoom = roomRepository.findUniqueNameToUpdate(newRoom.getCode(), id, newRoom.getBuilding().getId());
        if (checkRoom != null) {
            throw new GradeExceptions("Grade already exists");
        }
        existedRoom.setCode(newRoom.getCode());
        existedRoom.setUpdateAt(LocalDateTime.now());
        existedRoom.setBuilding(newRoom.getBuilding());


        Room savedRoom = roomRepository.save(existedRoom);
        return new RoomResponseDTO(savedRoom);
    }


    @Override
    public RoomResponseDTO deleteRoom(UUID id) {
        Room existedRoom = roomRepository.findById(id).get();
        if (existedRoom == null) {
            throw new BuildingExceptions("Building not found");
        }
        existedRoom.setUpdateAt(LocalDateTime.now());
        existedRoom.setStatus(!existedRoom.isStatus());
        return new RoomResponseDTO(roomRepository.save(existedRoom));
    }


    @Override
    public List<RoomResponseDTO> getAllRoom() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomResponseDTO> roomResponseDTOS = new ArrayList<>();
        for (Room room : rooms) {
            roomResponseDTOS.add(new RoomResponseDTO(room));
        }
        return roomResponseDTOS;
    }


    @Override
    public RoomResponseDTO getRoomById(UUID id) {
        Room room = roomRepository.findById(id).get();
        if (room == null) {
            throw new BuildingExceptions("Room not found");
        }
        return new RoomResponseDTO(room);
    }


    @Override
    public List<RoomResponseDTO> getRoomByBuilding(UUID id) {
        List<Room> roomList = roomRepository.findRoomByBuilding(id);
        List<RoomResponseDTO> roomLists = new ArrayList<>();
        for (Room room : roomList) {
            roomLists.add(new RoomResponseDTO(room));
        }
        return roomLists;
    }
}
