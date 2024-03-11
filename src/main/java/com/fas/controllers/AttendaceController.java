package com.fas.controllers;

import com.fas.models.dtos.requests.AttendanceRequestDTO;
import com.fas.models.dtos.responses.AttendanceResposeDTO;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AttendaceController {
    @Autowired
    private AttendanceService attendanceService;

    @PutMapping("/attendance/update/{attendanceId}")
    private MessageDetails<AttendanceResposeDTO> updateAttendance(@RequestBody AttendanceRequestDTO attendanceRequestDTO, @PathVariable UUID attendanceId) {
        AttendanceResposeDTO attendance = attendanceService.updateAttendance(attendanceRequestDTO, attendanceId);
        if(attendance == null) {
            return new MessageDetails<AttendanceResposeDTO>("Update attendance failed", null, Code.FAILURE);
        }
        return new MessageDetails<AttendanceResposeDTO>("Update attendance successfully", attendance, Code.SUCCESS);
    }
}
