package com.fas.services;

import com.fas.models.dtos.requests.AttendanceRequestDTO;
import com.fas.models.dtos.responses.AttendanceResposeDTO;
import com.fas.models.entities.Attendance;


import java.util.UUID;

public interface AttendanceService {

    Attendance createAttendance(AttendanceRequestDTO attendanceReq);

    AttendanceResposeDTO updateAttendance(AttendanceRequestDTO attendanceRequestDTO, UUID attendanceId);
}
