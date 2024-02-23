package com.fas.services;

import com.fas.models.dtos.requests.FeedBackRequestDTO;
import com.fas.models.dtos.responses.FeedBackResponseDTO;
import com.fas.models.entities.FeedBack;

import java.util.List;
import java.util.UUID;

public interface FeedBackService {

    public FeedBackResponseDTO createFeedBack(FeedBackRequestDTO feedBackRequestDTO);
    public FeedBackResponseDTO updateFeedBack(UUID feedBackId, FeedBackRequestDTO feedBackRequestDTO);

    public FeedBack getFeedBackById(UUID feedBackId);
    public List<FeedBackResponseDTO> getAllFeedBacks();
}
