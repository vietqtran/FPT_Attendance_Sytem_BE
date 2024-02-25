package com.fas.services.implementation;

import com.fas.models.dtos.requests.AssignFeedBackRequestDTO;
import com.fas.models.dtos.responses.AssignFeedBackResponseDTO;
import com.fas.models.entities.AssignFeedBack;
import com.fas.models.entities.Grade;
import com.fas.models.entities.Instructor;
import com.fas.models.exceptions.AssignFeedBackExceptions;
import com.fas.models.exceptions.CourseExceptions;
import com.fas.models.exceptions.GradeExceptions;
import com.fas.models.exceptions.TermExceptions;
import com.fas.repositories.AssignFeedBackRepository;
import com.fas.repositories.GradeRepository;
import com.fas.services.AssignFeedBackService;
import com.fas.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AssignFeedBackServiceImplementation implements AssignFeedBackService {

    @Autowired
    private AssignFeedBackRepository  assignFeedBackRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public AssignFeedBackResponseDTO creatFeedBack(AssignFeedBackRequestDTO assignFeedBackRequestDTO) {
        AssignFeedBack feedBack = assignFeedBackRequestDTO.getAssignFeedBack();

        AssignFeedBack checkFeedBack = assignFeedBackRepository.findAssignFeedBackByInstructorAndGrade(feedBack.getInstructor().getId(), feedBack.getGrade().getId());
        if (checkFeedBack != null) {
            throw new AssignFeedBackExceptions("FeedBack already exists");
        }
        if(feedBack.getStartDate().after(feedBack.getEndDate())) {
            throw new TermExceptions("Start date must be before end date");
        }
        AssignFeedBack newFeedBack = assignFeedBackRepository.save(feedBack);
        return new AssignFeedBackResponseDTO(newFeedBack);
    }

    @Override
    public AssignFeedBackResponseDTO updateFeedBack(AssignFeedBackRequestDTO assignFeedBackRequestDTO, UUID id) {
        AssignFeedBack existedFeedBack = assignFeedBackRepository.findById(id).get();
        AssignFeedBack newFeedBack = assignFeedBackRequestDTO.getAssignFeedBack();
        AssignFeedBack checkFeedBack = assignFeedBackRepository.findAssignFeedBackByInstructorAndGradeUnique(newFeedBack.getInstructor().getId(), id ,newFeedBack.getGrade().getId());
        if (checkFeedBack != null) {
            throw new AssignFeedBackExceptions("FeedBack already exists");
        }
        if(newFeedBack.getStartDate().after(newFeedBack.getEndDate())) {
            throw new TermExceptions("Start date must be before end date");
        }
        existedFeedBack.setGrade(newFeedBack.getGrade());
        existedFeedBack.setInstructor(newFeedBack.getInstructor());
        existedFeedBack.setUpdateAt(LocalDateTime.now());
        existedFeedBack.setStartDate(newFeedBack.getStartDate());
        existedFeedBack.setEndDate(newFeedBack.getEndDate());

        return new AssignFeedBackResponseDTO(assignFeedBackRepository.save(existedFeedBack));
    }

    @Override
    public AssignFeedBackResponseDTO deleteFeedBack(UUID id) {
        AssignFeedBack existedFeedBack = assignFeedBackRepository.findById(id).get();
        if (existedFeedBack == null) {
            throw new AssignFeedBackExceptions("FeedBack not found");
        }

        existedFeedBack.setUpdateAt(LocalDateTime.now());
        existedFeedBack.setStatus(!existedFeedBack.isStatus());
        return new AssignFeedBackResponseDTO(assignFeedBackRepository.save(existedFeedBack));
    }

    @Override
    public AssignFeedBackResponseDTO getAssignFeedBack(UUID id) {
        Optional<AssignFeedBack> feedBack = assignFeedBackRepository.findById(id);
        if(feedBack.isEmpty()) {
            throw new AssignFeedBackExceptions("FeedBack not found");
        }
        return new AssignFeedBackResponseDTO(feedBack.get());
    }

    @Override
    public List<AssignFeedBackResponseDTO> getAllAssignFeedBack() {
        List<AssignFeedBack> feedBacks = assignFeedBackRepository.findAll();
        List<AssignFeedBackResponseDTO> listFeedBacks = new ArrayList<>();
        for (AssignFeedBack feedBack : feedBacks) {
            AssignFeedBackResponseDTO feedBackResponseDTO = new AssignFeedBackResponseDTO(feedBack);
            listFeedBacks.add(feedBackResponseDTO);
        }
        return listFeedBacks;
    }

    @Override
    public List<AssignFeedBackResponseDTO> getAllAssignFeedBackByGrade(UUID gradeId) {
        Grade grade = gradeRepository.findById(gradeId).get();
        if (grade == null) {
            throw new GradeExceptions("Grade not found");
        }
        List<AssignFeedBack> feedBacks = assignFeedBackRepository.findByGrade(grade);
        List<AssignFeedBackResponseDTO> listFeedBacks = new ArrayList<>();
        for (AssignFeedBack feedBack : feedBacks) {
            AssignFeedBackResponseDTO feedBackResponseDTO = new AssignFeedBackResponseDTO(feedBack);
            listFeedBacks.add(feedBackResponseDTO);
        }
        return listFeedBacks;
    }
}
