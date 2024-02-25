package com.fas.controllers;


import com.fas.models.dtos.requests.AssignFeedBackRequestDTO;
import com.fas.models.dtos.requests.GradeRequestDTO;
import com.fas.models.dtos.responses.AssignFeedBackResponseDTO;
import com.fas.models.dtos.responses.GradeResponseDTO;
import com.fas.models.entities.Grade;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.AssignFeedBackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AssignFeedBackController {
    @Autowired
    private AssignFeedBackService assignFeedBackService;

    @PostMapping("/assignFeedBack")
    private MessageDetails<AssignFeedBackResponseDTO> createAssignFeedBack(@RequestBody @Valid AssignFeedBackRequestDTO feedbackReq) {
        AssignFeedBackResponseDTO grade = assignFeedBackService.creatFeedBack(feedbackReq);
        if(grade == null) {
            return new MessageDetails<AssignFeedBackResponseDTO>("Create feedback failed", null, Code.FAILURE);
        }
        return new MessageDetails<AssignFeedBackResponseDTO>("Grade feedback successfully", grade, Code.SUCCESS);
    }

    @GetMapping("/assignFeedBack")
    private MessageDetails<List<AssignFeedBackResponseDTO>> getAllGrade() {
        List<AssignFeedBackResponseDTO> feedBacks = assignFeedBackService.getAllAssignFeedBack();
        if(feedBacks == null) {
            return new MessageDetails<List<AssignFeedBackResponseDTO>>("Get all grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<AssignFeedBackResponseDTO>>("Get all grade successfully", feedBacks, Code.SUCCESS);
    }

    @GetMapping("/assignFeedBack/{assignFeedBackId}")
    private MessageDetails<AssignFeedBackResponseDTO> getGrade(@PathVariable UUID assignFeedBackId) {
        AssignFeedBackResponseDTO feedBack = assignFeedBackService.getAssignFeedBack(assignFeedBackId);
        if(feedBack == null) {
            return new MessageDetails<AssignFeedBackResponseDTO>("Get grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<AssignFeedBackResponseDTO>("Get grade successfully", feedBack, Code.SUCCESS);
    }

    @PutMapping("/assignFeedBack/update/{gradeId}")
    private MessageDetails<AssignFeedBackResponseDTO> updateGrade(@RequestBody AssignFeedBackRequestDTO assignFeedBackRequestDTO, @PathVariable UUID gradeId) {
        AssignFeedBackResponseDTO feedBack = assignFeedBackService.updateFeedBack(assignFeedBackRequestDTO, gradeId);
        if(feedBack == null) {
            return new MessageDetails<AssignFeedBackResponseDTO>("Update grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<AssignFeedBackResponseDTO>("Update Grade successfully", feedBack, Code.SUCCESS);
    }

    @PutMapping("/assignFeedBack/delete/{gradeId}")
    private MessageDetails<AssignFeedBackResponseDTO> deleteGrade(@PathVariable UUID gradeId) {
        AssignFeedBackResponseDTO feedBackResponseDTO = assignFeedBackService.deleteFeedBack(gradeId);
        if(feedBackResponseDTO == null) {
            return new MessageDetails<AssignFeedBackResponseDTO>("Delete grade failed", null, Code.FAILURE);
        }
        return new MessageDetails<AssignFeedBackResponseDTO>("Delete grade successfully", feedBackResponseDTO, Code.SUCCESS);
    }
}
