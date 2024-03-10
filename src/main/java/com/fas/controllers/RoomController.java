package com.fas.controllers;


import com.fas.models.dtos.requests.BuildingRequestDTO;
import com.fas.models.dtos.requests.RoomRequestDTO;
import com.fas.models.dtos.responses.BuildingResponseDTO;
import com.fas.models.dtos.responses.RoomResponseDTO;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.BuildingService;
import com.fas.services.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
public class RoomController {


    @Autowired
    private RoomService roomService;


    @PostMapping("/room")
    private MessageDetails<RoomResponseDTO> createRoom(@RequestBody @Valid RoomRequestDTO roomReq) {
        RoomResponseDTO building = roomService.createRoom(roomReq);
        if(building == null) {
            return new MessageDetails<RoomResponseDTO>("Create room failed", null, Code.FAILURE);
        }
        return new MessageDetails<RoomResponseDTO>("Room created successfully", building, Code.SUCCESS);
    }


    @GetMapping("/room")
    private MessageDetails<List<RoomResponseDTO>> getAllRoom() {
        List<RoomResponseDTO> buildings = roomService.getAllRoom();
        if(buildings == null) {
            return new MessageDetails<List<RoomResponseDTO>>("Get all room failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<RoomResponseDTO>>("Get all room successfully", buildings, Code.SUCCESS);
    }


    @GetMapping("/room/{roomId}")
    private MessageDetails<RoomResponseDTO> getRoom(@PathVariable UUID roomId) {
        RoomResponseDTO building = roomService.getRoomById(roomId);
        if(building == null) {
            return new MessageDetails<RoomResponseDTO>("Get room failed", null, Code.FAILURE);
        }
        return new MessageDetails<RoomResponseDTO>("Get room successfully", building, Code.SUCCESS);
    }


    @PutMapping("/room/update/{roomId}")
    private MessageDetails<RoomResponseDTO> updateRoom(@RequestBody RoomRequestDTO roomReq, @PathVariable UUID roomId) {
        RoomResponseDTO building = roomService.updateRoom(roomId, roomReq);
        if(building == null) {
            return new MessageDetails<RoomResponseDTO>("Update room failed", null, Code.FAILURE);
        }
        return new MessageDetails<RoomResponseDTO>("Update room successfully", building, Code.SUCCESS);
    }


    @PutMapping("/room/delete/{roomId}")
    private MessageDetails<RoomResponseDTO> deleteBuilding(@PathVariable UUID roomId) {
        RoomResponseDTO building = roomService.deleteRoom(roomId);
        if(building == null) {
            return new MessageDetails<RoomResponseDTO>("Delete room failed", null, Code.FAILURE);
        }
        return new MessageDetails<RoomResponseDTO>("Delete room successfully", building, Code.SUCCESS);
    }


    @GetMapping("/room/building/{buildingId}")
    private MessageDetails<List<RoomResponseDTO>> getAllGradeByCourse(@PathVariable UUID buildingId) {
        List<RoomResponseDTO> buildings = roomService.getRoomByBuilding(buildingId);
        if(buildings == null) {
            return new MessageDetails<List<RoomResponseDTO>>("Get all room failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<RoomResponseDTO>>("Get all room successfully", buildings, Code.SUCCESS);
    }


}
