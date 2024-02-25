package com.fas.services;

import com.fas.models.dtos.requests.GradeRequestDTO;
import com.fas.models.dtos.responses.GradeResponseDTO;
import com.fas.models.entities.Course;
import com.fas.models.entities.Grade;
import com.fas.models.entities.Term;
import com.fas.models.exceptions.GradeExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface GradeService {
    public GradeResponseDTO createGrade(GradeRequestDTO gradeRequestDTO);

    public GradeResponseDTO updateGrade(UUID id, GradeRequestDTO gradeRequestDTO);

    public GradeResponseDTO deleteGrade(UUID id);

    public List<GradeResponseDTO> getAllGrade();

    public Grade getGradeById(UUID id);

    public List<GradeResponseDTO> getGradeByMajor(UUID id);

    public List<GradeResponseDTO> getAllGradeByCourseAndTerm(UUID courseId, UUID termId);

    public Grade getGradeByCode(String code);

    public GradeResponseDTO assignGradeToStudent(UUID gradeId, UUID studentId);

    public GradeResponseDTO unassignGradeToStudent(UUID gradeId, UUID studentId);

    public List<GradeResponseDTO> getAllGradeByCourse(UUID courseId);

    public List<GradeResponseDTO> getAllGradeStudent(UUID studentId);
}
