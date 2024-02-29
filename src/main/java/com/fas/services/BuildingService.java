package com.fas.services;

import com.fas.models.dtos.requests.BuildingRequestDTO;
import com.fas.models.dtos.responses.BuildingResponseDTO;

import java.util.List;
import java.util.UUID;

public interface BuildingService {
    public BuildingResponseDTO createBuilding(BuildingRequestDTO buildingRequestDTO);

    public BuildingResponseDTO updateBuilding(UUID id, BuildingRequestDTO buildingRequestDTO);

    public BuildingResponseDTO deleteBuilding(UUID id);

    public List<BuildingResponseDTO> getAllBuilding();

    public BuildingResponseDTO getBuildingById(UUID id);

    public List<BuildingResponseDTO> getBuildingByCampus(Long id);
}
