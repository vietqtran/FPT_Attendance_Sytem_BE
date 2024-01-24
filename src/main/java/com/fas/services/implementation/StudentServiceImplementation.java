package com.fas.services.implementation;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.entities.Student;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.repositories.AccountRepository;
import com.fas.repositories.StudentRepository;
import com.fas.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Creates a new student based on the information provided in the student request DTO.
     *
     * @param  student   the student request DTO containing the information for the new student
     * @return          the student response DTO containing the information of the newly created student
     * @throws StudentExceptions   if the email provided already exists in the account repository
     */
    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO student) throws StudentExceptions {
        if (accountRepository.findByEmail(student.getEmail()) != null) {
            throw new StudentExceptions("Email already exists");
        }
        Student newStudent = student.getStudent();
        Student savedStudent = studentRepository.save(newStudent);
        return new StudentResponseDTO(savedStudent);
    }

    /**
     * Find a student by their ID.
     *
     * @param  studentId  the ID of the student to find
     * @return            the student found by the given ID
     */
    @Override
    public Student findStudentById(UUID studentId) throws StudentExceptions {
        Optional<Student> existedStudent = studentRepository.findById(studentId);
        if(existedStudent.isEmpty()){
            throw new StudentExceptions("Student not found");
        }
        return existedStudent.get();
    }

    /**
     * Updates a student with the given student ID using the information in the provided student request.
     *
     * @param  studentId  the UUID of the student to be updated
     * @param  student     the data to update the student with
     * @return             the response containing the updated student information
     */
    @Override
    public StudentResponseDTO updateStudent(UUID studentId, StudentRequestDTO student) throws StudentExceptions {
        Student oldStudent = findStudentById(studentId);
        Student newStudent = student.getStudent();

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
        oldStudent.setUpdateAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(oldStudent);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(savedStudent);
        return studentResponseDTO;
    }

    /**
     * Deletes a student by the given ID and returns the response DTO.
     *
     * @param  studentId   the ID of the student to be deleted
     * @return             the response DTO for the deleted student
     */
    @Override
    public StudentResponseDTO deleteStudent(UUID studentId) throws StudentExceptions {
        Student oldStudent = findStudentById(studentId);

        oldStudent.setUpdateAt(LocalDateTime.now());
        oldStudent.setStatus(!oldStudent.isStatus());
        Student updateStudent = studentRepository.save(oldStudent);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(updateStudent);
        return studentResponseDTO ;
    }

    /**
     * Retrieves a list of all students and transforms them into StudentResponseDTO objects.
     *
     * @return         	a list of StudentResponseDTO objects representing the students
     */
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
}
