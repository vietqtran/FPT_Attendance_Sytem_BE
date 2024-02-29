package com.fas.services.implementation;

import com.fas.models.dtos.requests.BuildingRequestDTO;
import com.fas.models.dtos.responses.BuildingResponseDTO;
import com.fas.models.entities.Building;
import com.fas.models.exceptions.BuildingExceptions;
import com.fas.models.exceptions.GradeExceptions;
import com.fas.repositories.BuildingRepository;
import com.fas.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuildingServiceImplementation implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public BuildingResponseDTO createBuilding(BuildingRequestDTO buildingRequestDTO) {
        Building building = buildingRequestDTO.getBuilding();
        Building checkBuilding = buildingRepository.findUniqueNameToAdd(building.getName(), building.getCampus().getId());
        if (checkBuilding != null) {
            throw new BuildingExceptions("Building already exists");
        }
        Building newBuilding = buildingRepository.save(building);
        return new BuildingResponseDTO(newBuilding);
    }

    @Override
    public BuildingResponseDTO updateBuilding(UUID id, BuildingRequestDTO buildingRequestDTO) {
        Building existedBuilding = buildingRepository.findById(id).get();
        if (existedBuilding == null) {
            throw new BuildingExceptions("Building not found");
        }
        Building newBuilding = buildingRequestDTO.getBuilding();
        Building checkBuilding = buildingRepository.findUniqueNameToUpdate(newBuilding.getName(), id, newBuilding.getCampus().getId());
        if (checkBuilding != null) {
            throw new GradeExceptions("Grade already exists");
        }
        existedBuilding.setName(newBuilding.getName());
        existedBuilding.setUpdateAt(LocalDateTime.now());
        existedBuilding.setCampus(newBuilding.getCampus());
        Building savedBuilding = buildingRepository.save(existedBuilding);
        return new BuildingResponseDTO(savedBuilding);
    }

    @Override
    public BuildingResponseDTO deleteBuilding(UUID id) {
        Building existedBuilding = buildingRepository.findById(id).get();
        if (existedBuilding == null) {
            throw new BuildingExceptions("Building not found");
        }
        existedBuilding.setUpdateAt(LocalDateTime.now());
        existedBuilding.setStatus(!existedBuilding.isStatus());
        return new BuildingResponseDTO(buildingRepository.save(existedBuilding));
    }

    @Override
    public List<BuildingResponseDTO> getAllBuilding() {
        List<Building> buildingList = buildingRepository.findAll();
        List<BuildingResponseDTO> buildingResponseDTOS = new ArrayList<>();
        for (Building building : buildingList) {
            buildingResponseDTOS.add(new BuildingResponseDTO(building));
        }
        return buildingResponseDTOS;
    }

    @Override
    public BuildingResponseDTO getBuildingById(UUID id) {
        Building building = buildingRepository.findById(id).get();
        if (building == null) {
            throw new BuildingExceptions("Building not found");
        }
        return new BuildingResponseDTO(building);
    }

    @Override
    public List<BuildingResponseDTO> getBuildingByCampus(Long id) {
        List<Building> buildingList = buildingRepository.findBuildingByCampus(id);
        List<BuildingResponseDTO> buildingResponseDTOS = new ArrayList<>();
        for (Building building : buildingList) {
            buildingResponseDTOS.add(new BuildingResponseDTO(building));
        }
        return buildingResponseDTOS;
    }
}
