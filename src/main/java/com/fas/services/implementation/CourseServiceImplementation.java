package com.fas.services.implementation;

import com.fas.models.dtos.requests.CourseRequestDTO;
import com.fas.models.dtos.responses.CourseResponseDTO;
import com.fas.models.entities.Course;
import com.fas.models.entities.Major;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.CourseExceptions;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.repositories.CourseRepository;
import com.fas.services.CourseService;
import com.fas.services.MajorService;
import com.fas.services.StudentService;
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

    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Override
    public CourseResponseDTO creatCourse(CourseRequestDTO courseRequest) {
        Course course = courseRequest.getCourse();
        Course checkCourse = courseRepository.findByCode(course.getCode());
        if (checkCourse != null) {
            throw new CourseExceptions("Course already exists");
        }
        Course newCourse = courseRepository.save(course);
        return new CourseResponseDTO(newCourse);
    }

    @Override
    public CourseResponseDTO updateCourse(CourseRequestDTO courseRequest, UUID id) {
        Course existedCourse = getCourseById(id);
        if(!existedCourse.isStatus()) {
            throw new CourseExceptions("Not available to update");
        }

        Course newCourse = courseRequest.getCourse();
        Course checkCourse = courseRepository.findByUniqueCode(newCourse.getCode(), id);

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
    public CourseResponseDTO deleteCourse(UUID id) {
        Course existedCourse = getCourseById(id);

        existedCourse.setUpdatedAt(LocalDateTime.now());
        existedCourse.setStatus(!existedCourse.isStatus());
        Course savedCourse = courseRepository.save(existedCourse);

        return new CourseResponseDTO(savedCourse);
    }

    @Override
    public Course getCourseById(UUID id) {
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
    @Override
    public CourseResponseDTO assignCourseToStudent(UUID courseId, UUID studentId) {
        Course course = getCourseById(courseId);
        Student student = studentService.findStudentById(studentId);

        if(course.getStudents().contains(student)) {
            throw new CourseExceptions("Student is already assigned to this course");
        }

        course.getStudents().add(student);
        student.getCourses().add(course);
        return new CourseResponseDTO(courseRepository.save(course));
    }

    @Override
    public CourseResponseDTO unAssignCourseToStudent(UUID courseId, UUID studentId) {
        Course course = getCourseById(courseId);
        Student student = studentService.findStudentById(studentId);

        if(!course.getStudents().contains(student)) {
            throw new CourseExceptions("Student is not assigned to this course");
        }

        course.getStudents().remove(student);
        student.getCourses().remove(course);
        return new CourseResponseDTO(courseRepository.save(course));
    }

    @Override
    public List<CourseResponseDTO> getAllCourseByMajor(UUID majorId) {
        Major major = majorService.getMajorById(majorId);
        List<Course> courses =  courseRepository.findCoursesByMajorsContaining(major);
        List<CourseResponseDTO> listCourse = new ArrayList<>();
        for(Course course : courses) {
            CourseResponseDTO courseResponseDTO = new CourseResponseDTO(course);
            listCourse.add(courseResponseDTO);
        }
        return listCourse;
    }


}
