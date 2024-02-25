package com.fas.services.implementation;

import com.fas.models.dtos.requests.AccountRequestDTO;
import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Course;
import com.fas.models.entities.Grade;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.CourseExceptions;
import com.fas.models.exceptions.GradeExceptions;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.repositories.AccountRepository;
import com.fas.repositories.CourseRepository;
import com.fas.repositories.GradeRepository;
import com.fas.repositories.StudentRepository;
import com.fas.services.AccountService;
import com.fas.services.GradeService;
import com.fas.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO student) throws StudentExceptions {
        System.out.println(student);
        if (accountRepository.findByEmail(student.getEmail()) != null) {
            throw new StudentExceptions("Email already exists");
        }

        if(studentRepository.findByPhone(student.getPhone()) != null){
            throw new StudentExceptions("Phone already exists");
        }

        if(studentRepository.findByIDCard(student.getIdCard()) != null){
            throw new StudentExceptions("IDCard already exists");
        }
        Student newStudent = student.getStudent();
        Student savedStudent = studentRepository.save(newStudent);

        AccountRequestDTO accountRequestDTO = new AccountRequestDTO(savedStudent.getEmail(), "123456", 1, 1, null, null, savedStudent.getId());
        accountService.createAccount(accountRequestDTO);

        return new StudentResponseDTO(savedStudent);
    }

    @Override
    public Student findStudentById(UUID studentId) throws StudentExceptions {
        Optional<Student> existedStudent = studentRepository.findById(studentId);
        if(existedStudent.isEmpty()){
            throw new StudentExceptions("Student not found");
        }
        return existedStudent.get();
    }


    @Override
    public StudentResponseDTO updateStudent(UUID studentId, StudentRequestDTO student) throws StudentExceptions {
        Student oldStudent = findStudentById(studentId);

        if(!oldStudent.isStatus()) {
            throw new StudentExceptions("Not available to update");
        }

        Student newStudent = student.getStudent();
        if(studentRepository.findByPhoneUpdate(newStudent.getPhone(), studentId) != null) {
            throw new StudentExceptions("Phone already exists");
        }
        if(studentRepository.findByIDCardUpdate(newStudent.getIdCard(), studentId) != null) {
            throw new StudentExceptions("ID Card already exists");
        }
        if(newStudent.getEmail() != null){
            oldStudent.setEmail(newStudent.getEmail());
        }
        if(newStudent.getUsername() != null){
            oldStudent.setUsername(newStudent.getUsername());
        }
        if(newStudent.getFirstName() != null){
            oldStudent.setFirstName(newStudent.getFirstName());
        }
        if(newStudent.getMiddleName() != null){
            oldStudent.setMiddleName(newStudent.getMiddleName());
        }
        if(newStudent.getLastName() != null){
            oldStudent.setLastName(newStudent.getLastName());
        }
        if(newStudent.getProfileImage() != null){
            oldStudent.setProfileImage(newStudent.getProfileImage());
        }
        if(newStudent.getPhone() != null){
            oldStudent.setPhone(newStudent.getPhone());
        }
        if(newStudent.getAddress() != null){
            oldStudent.setAddress(newStudent.getAddress());
        }
        if(newStudent.getBirthDay() != null){
            oldStudent.setBirthDay(newStudent.getBirthDay());
        }
        if(newStudent.getMajor() != null){
            oldStudent.setMajor(newStudent.getMajor());
        }
        if(newStudent.getCampus() != null){
            oldStudent.setCampus(newStudent.getCampus());
        }
        if(newStudent.isGender() != oldStudent.isGender()){
            oldStudent.setGender(newStudent.isGender());
        }
        if(newStudent.getIdCard() != null){
            oldStudent.setIdCard(newStudent.getIdCard());
        }

        oldStudent.setUpdateAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(oldStudent);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(savedStudent);
        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO deleteStudent(UUID studentId) throws StudentExceptions {
        Student oldStudent = findStudentById(studentId);

        oldStudent.setUpdateAt(LocalDateTime.now());
        oldStudent.setStatus(!oldStudent.isStatus());
        Student updateStudent = studentRepository.save(oldStudent);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(updateStudent);
        return studentResponseDTO;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDTO> studentResponseDTOS = new ArrayList<>();
        for (Student student : students) {
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO(student);
            studentResponseDTOS.add(studentResponseDTO);
        }
        return studentResponseDTOS;
    }

    @Override
    public Student findStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email);
        return student;
    }

    @Override
    public Page<StudentResponseDTO> filterAndSortStudents(UUID gradeId, UUID courseId, UUID majorId, String searchValue, String order, String page, String size) {
        Grade grade = gradeRepository.findById(gradeId).orElseThrow(() -> new GradeExceptions("Grade not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseExceptions("Course not found"));

        List<Student> students = studentRepository.filterAndSortStudents(grade.getId(), course.getId(), majorId, searchValue, order);
        List<StudentResponseDTO> listStudent = new ArrayList<>();
        for (Student student : students) {
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO(student);
            listStudent.add(studentResponseDTO);
        }
        if (page == null || size == null) {
            return new PageImpl<>(listStudent);
        }
        int pageNumber = Integer.parseInt(page);
        int sizeNumber = Integer.parseInt(size);

        int totalSize = listStudent.size();
        int startIndex = (pageNumber - 1) * sizeNumber;
        int endIndex = Math.min(startIndex + sizeNumber, totalSize);
        int totalPage = (int) Math.ceil((double) totalSize / sizeNumber);

        if(pageNumber <= 0) {
            pageNumber = 1;
        }

        if (pageNumber > totalPage) {
            pageNumber = totalPage;
            startIndex = (pageNumber - 1) * sizeNumber;
            endIndex = Math.min(startIndex + sizeNumber, totalSize);
        }

        List<StudentResponseDTO> listStudentPage;
        if (startIndex < totalSize) {
            listStudentPage = listStudent.subList(startIndex, endIndex);
        } else {
            listStudentPage = Collections.emptyList();
        }

        return new PageImpl<>(listStudentPage, PageRequest.of(pageNumber - 1, sizeNumber), totalSize);
    }

}
