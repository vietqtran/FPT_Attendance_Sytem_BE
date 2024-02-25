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
        return new MessageDetails<>("Feedback created successfully", feedback, Code.SUCCESS);
    }

    @GetMapping("/feedback/{feedbackId}")
    private MessageDetails<FeedBackResponseDTO> getCourseById(@PathVariable UUID feedbackId) {
        FeedBack feedBack = feedBackService.getFeedBackById(feedbackId);
        if(feedBack == null) {
            return new MessageDetails<>("Get feedBack failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get feedBack successfully", new FeedBackResponseDTO(feedBack), Code.SUCCESS);
    }

    @GetMapping("/feedback")
    private MessageDetails<List<FeedBackResponseDTO>> getAllCourse() {
        List<FeedBackResponseDTO> feedBacks = feedBackService.getAllFeedBacks();
        return new MessageDetails<>("Get all Feedback successfully", feedBacks, Code.SUCCESS);
    }

    @PutMapping("/feedback/update/{feedbackId}")
    private MessageDetails<FeedBackResponseDTO> updateCourse(@RequestBody FeedBackRequestDTO feedbackReq, @PathVariable UUID feedbackId) {
        FeedBackResponseDTO feedback = feedBackService.updateFeedBack(feedbackId, feedbackReq);
        return new MessageDetails<>("Update Feedback successfully", feedback, Code.SUCCESS);
    }


}
