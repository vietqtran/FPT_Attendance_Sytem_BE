package com.fas.services;


import com.fas.models.dtos.requests.ActivityRequestDTO;
import com.fas.models.dtos.requests.AssignRequestDTO;
import com.fas.models.dtos.responses.AssignResponseDTO;
import com.fas.models.exceptions.AssignException;


import java.util.List;
import java.util.UUID;


public interface AssignService {


   AssignResponseDTO createAssign(AssignRequestDTO assignRequestDTO, ActivityRequestDTO activityRequestDTO);


   List<AssignResponseDTO> getAllAssigns();


   AssignResponseDTO updateAssign(AssignRequestDTO assignRequestDTO, UUID assignId);


   AssignResponseDTO deleteAssign(UUID id);


   AssignResponseDTO getAssignById(UUID id)  throws AssignException;

}
