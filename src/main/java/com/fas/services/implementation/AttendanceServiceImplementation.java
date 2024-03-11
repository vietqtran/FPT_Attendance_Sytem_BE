package com.fas.services.implementation;

import com.fas.models.dtos.requests.AttendanceRequestDTO;
import com.fas.models.dtos.responses.AttendanceResposeDTO;
import com.fas.models.dtos.responses.BuildingResponseDTO;
import com.fas.models.entities.Attendance;
import com.fas.models.entities.Building;
import com.fas.models.exceptions.BuildingExceptions;
import com.fas.repositories.AttendanceRepository;
import com.fas.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AttendanceServiceImplementation implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance createAttendance(AttendanceRequestDTO attendanceReq) {
        Attendance attendance = attendanceReq.getAttendance();
        Attendance newAttendance = attendanceRepository.save(attendance);
        return newAttendance;
    }

    @Override
    public AttendanceResposeDTO updateAttendance(AttendanceRequestDTO attendanceRequestDTO, UUID attendanceId) {
        Attendance existedAttendance = attendanceRepository.findById(attendanceId).get();
        if (existedAttendance == null) {
            throw new BuildingExceptions("Attendance not found");
        }
        Attendance newAttendance = attendanceRequestDTO.getAttendance();
        existedAttendance.setContent(newAttendance.getContent());
        existedAttendance.setStatus(newAttendance.isStatus());
        Attendance savedAttendance = attendanceRepository.save(existedAttendance);

        return new AttendanceResposeDTO(savedAttendance);
    }
}
