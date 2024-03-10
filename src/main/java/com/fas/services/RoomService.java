package com.fas.services;


import com.fas.models.dtos.requests.BuildingRequestDTO;
import com.fas.models.dtos.requests.RoomRequestDTO;
import com.fas.models.dtos.responses.BuildingResponseDTO;
import com.fas.models.dtos.responses.RoomResponseDTO;


import java.util.List;
import java.util.UUID;


public interface RoomService {


    public RoomResponseDTO createRoom(RoomRequestDTO roomRequestDTO);


    public RoomResponseDTO updateRoom(UUID id, RoomRequestDTO roomRequestDTO);


    public RoomResponseDTO deleteRoom(UUID id);


    public List<RoomResponseDTO> getAllRoom();


    public RoomResponseDTO getRoomById(UUID id);


    public List<RoomResponseDTO> getRoomByBuilding(UUID id);
}
