package com.fas.services.implementation;

import com.fas.controllers.GradeController;
import com.fas.models.dtos.requests.GradeRequestDTO;
import com.fas.models.dtos.responses.GradeResponseDTO;
import com.fas.models.entities.*;
import com.fas.models.exceptions.GradeExceptions;
import com.fas.repositories.GradeRepository;
import com.fas.services.*;
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

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private TermService termService;

    @Override
    public GradeResponseDTO createGrade(GradeRequestDTO gradeRequestDTO) {
        Grade grade = gradeRequestDTO.getGrade();
        Grade checkGrade = gradeRepository.findUniqueCodeToAdd(grade.getCode(), grade.getCampus().getId());
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
        Grade checkGrade = gradeRepository.findUniqueCodeToUpdate(newGrade.getCode(), id, newGrade.getCampus().getId());
        if (checkGrade != null) {
            throw new GradeExceptions("Grade already exists");
        }
        existedGrade.setCode(newGrade.getCode());
        existedGrade.setUpdatedAt(LocalDateTime.now());
        existedGrade.setMajor(newGrade.getMajor());
        existedGrade.setCampus(newGrade.getCampus());

        Grade savedGrade = gradeRepository.save(existedGrade);
        return new GradeResponseDTO(savedGrade);
    }

    @Override
    public GradeResponseDTO deleteGrade(UUID id) {
        Grade existedGrade = getGradeById(id);
        existedGrade.setUpdatedAt(LocalDateTime.now());
        existedGrade.setStatus(!existedGrade.isStatus());
        return new GradeResponseDTO(gradeRepository.save(existedGrade));
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
    public List<GradeResponseDTO> getGradeByMajor(UUID id) {
        Major major = majorService.getMajorById(id);
        List<Grade> grades = gradeRepository.findGradeByMajor(major);
        List<GradeResponseDTO> gradeResponseDTOS = new ArrayList<>();
        for (Grade grade : grades) {
            GradeResponseDTO gradeResponseDTO = new GradeResponseDTO(grade);
            gradeResponseDTOS.add(gradeResponseDTO);
        }
        return gradeResponseDTOS;
    }

    @Override
    public Grade getGradeByCode(String code) {
        Grade grade = gradeRepository.findByCode(code);
        return grade;
    }

    public GradeResponseDTO assignGradeToStudent(UUID gradeId, UUID studentId) {
        Grade grade = getGradeById(gradeId);
        Student student = studentService.findStudentById(studentId);

        if(grade.getStudents().contains(student)) {
            throw new GradeExceptions("Student is already assigned to this grade");
        }

        grade.getStudents().add(student);
        return new GradeResponseDTO(gradeRepository.save(grade));
    }

    public GradeResponseDTO unassignGradeToStudent(UUID gradeId, UUID studentId) {
        Grade grade = getGradeById(gradeId);
        Student student = studentService.findStudentById(studentId);

        if(!grade.getStudents().contains(student)) {
            throw new GradeExceptions("Student is not assigned to this grade");
        }

        grade.getStudents().remove(student);
        return new GradeResponseDTO(gradeRepository.save(grade));
    }

    @Override
    public List<GradeResponseDTO> getAllGradeByCourse(UUID courseId) {
        Course course = courseService.getCourseById(courseId);
        List<Grade> grades = gradeRepository.findGradesByCoursesContaining(course);
        List<GradeResponseDTO> listGrade = new ArrayList<>();
        for (Grade grade : grades) {
            GradeResponseDTO gradeResponseDTO = new GradeResponseDTO(grade);
            listGrade.add(gradeResponseDTO);
        }
        return listGrade;
    }

    @Override
    public List<GradeResponseDTO> getAllGradeByCourseAndTerm(UUID courseId, UUID termId) {
        Course course = courseService.getCourseById(courseId);
        Term term = termService.getTermById(termId);
        List<Grade> grades = gradeRepository.findGradesByCoursesAndTerms(course, term);
        List<GradeResponseDTO> listGrade = new ArrayList<>();
        for (Grade grade : grades) {
            GradeResponseDTO gradeResponseDTO = new GradeResponseDTO(grade);
            listGrade.add(gradeResponseDTO);
        }
        return listGrade;
    }

    @Override
    public List<GradeResponseDTO> getAllGradeStudent(UUID studentId) {
        Student student = studentService.findStudentById(studentId);
        List<Grade> grades = gradeRepository.findGradesByStudentsContains(student);
        List<GradeResponseDTO> listGrade = new ArrayList<>();
        for (Grade grade : grades) {
            GradeResponseDTO gradeResponseDTO = new GradeResponseDTO(grade);
            listGrade.add(gradeResponseDTO);
        }
        return listGrade;
    }
}
