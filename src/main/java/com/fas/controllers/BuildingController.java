package com.fas.controllers;


import com.fas.models.dtos.requests.BuildingRequestDTO;
import com.fas.models.dtos.responses.BuildingResponseDTO;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.BuildingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("/building")
    private MessageDetails<BuildingResponseDTO> createBuilding(@RequestBody @Valid BuildingRequestDTO buildingReq) {
        BuildingResponseDTO building = buildingService.createBuilding(buildingReq);
        if(building == null) {
            return new MessageDetails<BuildingResponseDTO>("Create building failed", null, Code.FAILURE);
        }
        return new MessageDetails<BuildingResponseDTO>("Building created successfully", building, Code.SUCCESS);
    }

    @GetMapping("/building")
    private MessageDetails<List<BuildingResponseDTO>> getAllBuilding() {
        List<BuildingResponseDTO> buildings = buildingService.getAllBuilding();
        if(buildings == null) {
            return new MessageDetails<List<BuildingResponseDTO>>("Get all grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<BuildingResponseDTO>>("Get all grade successfully", buildings, Code.SUCCESS);
    }

    @GetMapping("/building/{buildingId}")
    private MessageDetails<BuildingResponseDTO> getBuilding(@PathVariable UUID buildingId) {
        BuildingResponseDTO building = buildingService.getBuildingById(buildingId);
        if(building == null) {
            return new MessageDetails<BuildingResponseDTO>("Get building failed", null, Code.FAILURE);
        }
        return new MessageDetails<BuildingResponseDTO>("Get building successfully", building, Code.SUCCESS);
    }

    @PutMapping("/building/update/{buildingId}")
    private MessageDetails<BuildingResponseDTO> updateBuilding(@RequestBody BuildingRequestDTO buildingReq, @PathVariable UUID buildingId) {
        BuildingResponseDTO building = buildingService.updateBuilding(buildingId, buildingReq);
        if(building == null) {
            return new MessageDetails<BuildingResponseDTO>("Update building failed", null, Code.FAILURE);
        }
        return new MessageDetails<BuildingResponseDTO>("Update building successfully", building, Code.SUCCESS);
    }

    @PutMapping("/building/delete/{buildingId}")
    private MessageDetails<BuildingResponseDTO> deleteBuilding(@PathVariable UUID buildingId) {
        BuildingResponseDTO building = buildingService.deleteBuilding(buildingId);
        if(building == null) {
            return new MessageDetails<BuildingResponseDTO>("Delete building failed", null, Code.FAILURE);
        }
        return new MessageDetails<BuildingResponseDTO>("Delete building successfully", building, Code.SUCCESS);
    }

    @GetMapping("/building/campus/{campusId}")
    private MessageDetails<List<BuildingResponseDTO>> getAllGradeByCourse(@PathVariable Long campusId) {
        List<BuildingResponseDTO> buildings = buildingService.getBuildingByCampus(campusId);
        if(buildings == null) {
            return new MessageDetails<List<BuildingResponseDTO>>("Get all grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<BuildingResponseDTO>>("Get all grade successfully", buildings, Code.SUCCESS);
    }

}
