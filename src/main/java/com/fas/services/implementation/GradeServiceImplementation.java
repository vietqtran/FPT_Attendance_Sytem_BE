package com.fas.services.implementation;

import com.fas.models.dtos.requests.GradeRequestDTO;
import com.fas.models.dtos.responses.GradeResponseDTO;
import com.fas.models.entities.Grade;
import com.fas.models.exceptions.GradeExceptions;
import com.fas.repositories.GradeRepository;
import com.fas.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GradeServiceImplementation implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;
    @Override
    public GradeResponseDTO createGrade(GradeRequestDTO gradeRequestDTO) {
        Grade grade = gradeRequestDTO.getGrade();
        Grade checkGrade = gradeRepository.findByCode(grade.getCode());
        if (checkGrade != null) {
            throw new GradeExceptions("Grade already exists");
        }
        Grade newGrade = gradeRepository.save(grade);
        return new GradeResponseDTO(newGrade);
    }

    @Override
    public GradeResponseDTO updateGrade(UUID id, GradeRequestDTO gradeRequestDTO) {
        Grade existedGrade = getGradeById(id);
        Grade newGrade = gradeRequestDTO.getGrade();
        Grade checkGrade = getGradeByCode(newGrade.getCode());
        if (checkGrade != null) {
            throw new GradeExceptions("Grade already exists");
        }
        existedGrade.setCode(newGrade.getCode());
        existedGrade.setUpdatedAt(LocalDateTime.now());
        Grade savedGrade = gradeRepository.save(existedGrade);
        return new GradeResponseDTO(savedGrade);
    }

    @Override
    public void deleteGrade(UUID id) {
        Grade existedGrade = getGradeById(id);
        existedGrade.setUpdatedAt(LocalDateTime.now());
        existedGrade.setStatus(false);
        gradeRepository.save(existedGrade);
    }

    @Override
    public List<GradeResponseDTO> getAllGrade() {
        List<Grade> grades = gradeRepository.findAll();
        List<GradeResponseDTO> gradeResponseDTOS = new ArrayList<>();
        for (Grade grade : grades) {
            GradeResponseDTO gradeResponseDTO = new GradeResponseDTO(grade);
            gradeResponseDTOS.add(gradeResponseDTO);
        }
        return gradeResponseDTOS;
    }

    @Override
    public Grade getGradeById(UUID id) {
        Optional<Grade> grade = gradeRepository.findById(id);
        if(grade.isEmpty()) {
            throw new GradeExceptions("Grade not found");
        }
        return grade.get();
    }

    @Override
    public Grade getGradeByCode(String code) {
        Grade grade = gradeRepository.findByCode(code);
        return grade;
    }
}