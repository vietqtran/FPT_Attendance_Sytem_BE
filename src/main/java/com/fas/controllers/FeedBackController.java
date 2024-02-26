package com.fas.controllers;


import com.fas.models.dtos.requests.CourseRequestDTO;
import com.fas.models.dtos.requests.FeedBackRequestDTO;
import com.fas.models.dtos.responses.CourseResponseDTO;
import com.fas.models.dtos.responses.FeedBackResponseDTO;
import com.fas.models.entities.Course;
import com.fas.models.entities.FeedBack;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.FeedBackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @PostMapping("/feedback")
    private MessageDetails<FeedBackResponseDTO> createFeedBack(@RequestBody @Valid FeedBackRequestDTO feedbackReq) {
        FeedBackResponseDTO feedback = feedBackService.createFeedBack(feedbackReq);
        if(feedback == null) {
            return new MessageDetails<>("Feedback created failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Feedback created successfully", feedback, Code.SUCCESS);
    }

    @GetMapping("/feedback/{feedbackId}")
    private MessageDetails<FeedBackResponseDTO> getFeedBackById(@PathVariable UUID feedbackId) {
        FeedBack feedBack = feedBackService.getFeedBackById(feedbackId);
        if(feedBack == null) {
            return new MessageDetails<>("Get feedBack failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get feedBack successfully", new FeedBackResponseDTO(feedBack), Code.SUCCESS);
    }

    @GetMapping("/feedback")
    private MessageDetails<List<FeedBackResponseDTO>> getAllFeedBacks() {
        List<FeedBackResponseDTO> feedBacks = feedBackService.getAllFeedBacks();
        if(feedBacks == null) {
            return new MessageDetails<>("Get all feedbacks failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get all feedbacks successfully", feedBacks, Code.SUCCESS);
    }

    @PutMapping("/feedback/update/{feedbackId}")
    private MessageDetails<FeedBackResponseDTO> updateFeedBack(@RequestBody FeedBackRequestDTO feedbackReq, @PathVariable UUID feedbackId) {
        FeedBackResponseDTO feedback = feedBackService.updateFeedBack(feedbackId, feedbackReq);
        if(feedback == null) {
            return new MessageDetails<>("Update feedback failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Update feedback successfully", feedback, Code.SUCCESS);
    }

    @PutMapping("/feedback/delete/{feedbackId}")
    private MessageDetails<FeedBackResponseDTO> updateFeedBack(@PathVariable UUID feedbackId) {
        FeedBackResponseDTO feedback = feedBackService.deleteFeedBack(feedbackId);
        if(feedback == null) {
            return new MessageDetails<>("Update feedback failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Update feedback successfully", feedback, Code.SUCCESS);
    }

    @GetMapping("/feedback/assign/{assignId}/student/{studentId}")
    private MessageDetails<FeedBackResponseDTO> getAllCFeedBacksByAssignAndStudent(@PathVariable UUID assignId, @PathVariable UUID studentId) {
        FeedBack feedBacks = feedBackService.checkFeedBack(assignId, studentId);
        if(feedBacks == null) {
            return new MessageDetails<>("Get all feedbacks failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get all feedbacks successfully", new FeedBackResponseDTO(feedBacks), Code.SUCCESS);
    }

}
