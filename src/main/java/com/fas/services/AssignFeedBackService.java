package com.fas.services;

import com.fas.models.dtos.requests.AssignFeedBackRequestDTO;
import com.fas.models.dtos.requests.CourseRequestDTO;
import com.fas.models.dtos.responses.AssignFeedBackResponseDTO;
import com.fas.models.dtos.responses.CourseResponseDTO;
import com.fas.models.entities.AssignFeedBack;
import com.fas.models.entities.Course;

import java.util.List;
import java.util.UUID;

public interface AssignFeedBackService {
    public AssignFeedBackResponseDTO creatFeedBack(AssignFeedBackRequestDTO assignFeedBackRequestDTO);

    public AssignFeedBackResponseDTO updateFeedBack(AssignFeedBackRequestDTO assignFeedBackRequestDTO, UUID id);

    public AssignFeedBackResponseDTO deleteFeedBack(UUID id);

    public AssignFeedBackResponseDTO getAssignFeedBack(UUID id);

    public List<AssignFeedBackResponseDTO> getAllAssignFeedBack();
}
