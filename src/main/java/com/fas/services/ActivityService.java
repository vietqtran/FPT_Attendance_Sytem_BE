package com.fas.services;

import com.fas.models.dtos.requests.ActivityRequestDTO;
import com.fas.models.dtos.responses.ActivityResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ActivityService {
    List<ActivityResponseDTO> createActivity(ActivityRequestDTO activityRequestDTO, UUID assignId);

    List<ActivityResponseDTO> getAllActivity();

    ActivityResponseDTO updateActivity(ActivityRequestDTO activityRequestDTO, UUID activityId);

    ActivityResponseDTO getActivityById(UUID id);
}