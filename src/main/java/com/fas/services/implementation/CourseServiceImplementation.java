package com.fas.services.implementation;

import com.fas.models.dtos.requests.CourseRequestDTO;
import com.fas.models.dtos.responses.CourseResponseDTO;
import com.fas.models.entities.Course;
import com.fas.models.entities.Major;
import com.fas.models.exceptions.CourseExceptions;
import com.fas.repositories.CourseRepository;
import com.fas.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CourseServiceImplementation implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public CourseResponseDTO creatMajor(CourseRequestDTO courseRequest) {
        Course course = courseRequest.getCourse();
        Course checkCourse = courseRepository.findByCode(course.getCode());
        if (checkCourse != null) {
            throw new CourseExceptions("Course already exists");
        }
        Course newCourse = courseRepository.save(course);
        return new CourseResponseDTO(newCourse);
    }

    @Override
    public CourseResponseDTO updateMajor(CourseRequestDTO courseRequest, UUID id) {
        Course existedCourse = getMajorById(id);
        Course newCourse = courseRequest.getCourse();
        Course checkCourse = courseRepository.findByCode(newCourse.getCode());
        if (checkCourse != null) {
            throw new CourseExceptions("Course already exists");
        }
        existedCourse.setCode(newCourse.getCode());
        existedCourse.setName(newCourse.getName());
        existedCourse.setUpdatedAt(LocalDateTime.now());
        existedCourse.setDescription(newCourse.getDescription());
        existedCourse.setNoCredit(newCourse.getNoCredit());

        Course savedCourse = courseRepository.save(existedCourse);
        return new CourseResponseDTO(savedCourse);
    }

    @Override
    public CourseResponseDTO deleteMajor(UUID id) {
        Course existedCourse = getMajorById(id);

        existedCourse.setUpdatedAt(LocalDateTime.now());
        existedCourse.setStatus(false);
        Course savedCourse = courseRepository.save(existedCourse);

        return new CourseResponseDTO(savedCourse);
    }

    @Override
    public Course getMajorById(UUID id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()) {
            throw new CourseExceptions("Course not found");
        }
        return course.get();
    }

    @Override
    public List<CourseResponseDTO> getAllCourse() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> listCourse = new ArrayList<>();
        for(Course course : courses) {
            CourseResponseDTO courseResponseDTO = new CourseResponseDTO(course);
            listCourse.add(courseResponseDTO);
        }
        return listCourse;
    }

    @Override
    public Course getCourseByCode(String code) {
        Course course = courseRepository.findByCode(code);
        return course;
    }
}
