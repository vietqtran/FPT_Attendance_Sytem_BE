package com.fas.services.implementation;

import com.fas.models.dtos.requests.FeedBackRequestDTO;
import com.fas.models.dtos.responses.FeedBackResponseDTO;
import com.fas.models.entities.AssignFeedBack;
import com.fas.models.entities.FeedBack;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.AssignFeedBackExceptions;
import com.fas.models.exceptions.CourseExceptions;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.repositories.AssignFeedBackRepository;
import com.fas.repositories.FeedBackRepository;
import com.fas.repositories.StudentRepository;
import com.fas.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeedBackServiceImplementation implements FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Autowired
    private AssignFeedBackRepository assignFeedBackRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public FeedBackResponseDTO createFeedBack(FeedBackRequestDTO feedBackRequestDTO) {
        FeedBack feedBack = feedBackRequestDTO.getFeedBack();
        FeedBack newFeedBack = feedBackRepository.save(feedBack);
        return new FeedBackResponseDTO(newFeedBack);
    }
    @Override
    public FeedBackResponseDTO updateFeedBack(UUID feedBackId, FeedBackRequestDTO feedBackRequestDTO) {
        FeedBack existedFeedback = getFeedBackById(feedBackId);

        FeedBack newFeedback = feedBackRequestDTO.getFeedBack();

        existedFeedback.setComment(newFeedback.getComment());
        existedFeedback.setUpdatedAt(LocalDateTime.now());
        existedFeedback.setPunctuality(newFeedback.getPunctuality());
        existedFeedback.setTeachingSkill(newFeedback.getTeachingSkill());
        existedFeedback.setAdequatelySyllabus(newFeedback.getAdequatelySyllabus());
        existedFeedback.setSupport(newFeedback.getSupport());
        existedFeedback.setResponseQuestion(newFeedback.getResponseQuestion());
        existedFeedback.setTeachingMethods(newFeedback.getTeachingMethods());
        existedFeedback.setDispositionStudents(newFeedback.getDispositionStudents());
        existedFeedback.setOverall(newFeedback.getOverall());

        FeedBack savedFeedback = feedBackRepository.save(existedFeedback);
        return new FeedBackResponseDTO(savedFeedback);
    }


    @Override
    public FeedBack getFeedBackById(UUID feedBackId) {
        Optional<FeedBack> feedBack = feedBackRepository.findById(feedBackId);
        if(feedBack.isEmpty()) {
            throw new CourseExceptions("FeedBack not found");
        }
        return feedBack.get();
    }
    @Override
    public List<FeedBackResponseDTO> getAllFeedBacks() {
        List<FeedBack> feedBacks = feedBackRepository.findAll();
        List<FeedBackResponseDTO> listFeedBacks = new ArrayList<>();
        for(FeedBack feedBack : feedBacks) {
            FeedBackResponseDTO feedBackResponseDTO = new FeedBackResponseDTO(feedBack);
            listFeedBacks.add(feedBackResponseDTO);
        }
        return listFeedBacks;
    }

    @Override
    public FeedBack checkFeedBack(UUID assignFeedBackId, UUID studentId) {
        AssignFeedBack assignFeedBack = assignFeedBackRepository.findById(assignFeedBackId).orElseThrow(() -> new AssignFeedBackExceptions("AssignFeedBack not found"));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentExceptions("Student not found"));

        FeedBack feedBack = feedBackRepository.getFeedBackByStudentIdAndAssignFeedBack(student.getId(), assignFeedBack.getId());

        return feedBack;
    }

}
