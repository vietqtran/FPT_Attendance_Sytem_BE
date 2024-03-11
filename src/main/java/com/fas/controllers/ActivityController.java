package com.fas.controllers;

import com.fas.models.dtos.requests.ActivityRequestDTO;
import com.fas.models.dtos.responses.ActivityResponseDTO;
import com.fas.models.entities.Student;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.ActivityService;
import com.fas.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/assign/{assignId}/activity")
    private MessageDetails<List<ActivityResponseDTO>> createActivity(@RequestBody @Valid ActivityRequestDTO activityRequestDTO, @PathVariable UUID assignId) {
        List<ActivityResponseDTO> activity = activityService.createActivity(activityRequestDTO, assignId);
        if(activity == null) {
            return new MessageDetails<List<ActivityResponseDTO>>("Create activity failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<ActivityResponseDTO>>("Create activity successfully", activity, Code.SUCCESS);
    }

    @GetMapping("/activity")
    private MessageDetails<List<ActivityResponseDTO>> getAllAssigns() {
        List<ActivityResponseDTO> activity = activityService.getAllActivity();
        if(activity == null) {
            return new MessageDetails<List<ActivityResponseDTO>>("Get all activity failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<ActivityResponseDTO>>("Get all activity successfully", activity, Code.SUCCESS);
    }

    @GetMapping("/activity/{activityId}")
    private MessageDetails<ActivityResponseDTO> getActivityById(@PathVariable UUID activityId) {
        ActivityResponseDTO activity = activityService.getActivityById(activityId);
        if(activity == null) {
            return new MessageDetails<ActivityResponseDTO>("Get activity failed", null, Code.FAILURE);
        }
        return new MessageDetails<ActivityResponseDTO>("Get activity successfully", activity, Code.SUCCESS);
    }

    @PutMapping("/activity/update/{activityId}")
    private MessageDetails<ActivityResponseDTO> updateActivity(@RequestBody ActivityRequestDTO activityRequestDTO, @PathVariable UUID activityId) {
        ActivityResponseDTO activity = activityService.updateActivity(activityRequestDTO, activityId);
        if(activity == null) {
            return new MessageDetails<ActivityResponseDTO>("Update activity failed", null, Code.FAILURE);
        }
        return new MessageDetails<ActivityResponseDTO>("Update activity successfully", activity, Code.SUCCESS);
    }

    @GetMapping("/activity/student/{studentId}")
    private MessageDetails<List<ActivityResponseDTO>> findActivityByStudentId(@PathVariable UUID studentId, @RequestParam Integer week, @RequestParam Integer year) {

        Student student = studentService.findStudentById(studentId);
        List<ActivityResponseDTO> activity = activityService.findActivityByStudentIdByWeekAndYear(student, week, year);
        if(activity == null) {
            return new MessageDetails<List<ActivityResponseDTO>>("Get activity failed", null, Code.FAILURE);
        }
        return new MessageDetails<List<ActivityResponseDTO>>("Get activity successfully", activity, Code.SUCCESS);
    }
}
