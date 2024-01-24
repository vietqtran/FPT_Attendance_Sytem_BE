package com.fas.services.implementation;

import com.fas.models.dtos.requests.StudentRequestDTO;
import com.fas.models.dtos.responses.InstructorResponseDTO;
import com.fas.models.entities.Instructor;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.services.InstructorService;

import java.util.UUID;

public class InstructorServiceImplementation implements InstructorService {

    /**
     * Creates a new student with the provided information.
     *
     * @param  student  the student request data transfer object
     * @return          the instructor response data transfer object
     */
    @Override
    public InstructorResponseDTO createStudent(StudentRequestDTO student) throws StudentExceptions {
        return null;
    }

    /**
     * Find a student by their ID.
     *
     * @param  studentId  the ID of the student to find
     * @return            the instructor associated with the student ID
     */
    @Override
    public Instructor findStudentById(UUID studentId) throws StudentExceptions {
        return null;
    }

    /**
     * Updates a student with the given studentId using the provided student information.
     *
     * @param  studentId  the unique identifier of the student to be updated
     * @param  student    the updated information of the student
     * @return            an InstructorResponseDTO representing the updated student
     * @throws StudentExceptions if an error occurs during the update process
     */
    @Override
    public InstructorResponseDTO updateStudent(UUID studentId, StudentRequestDTO student) throws StudentExceptions {
        return null;
    }

    /**
     * Deletes a student with the given ID.
     *
     * @param  studentId   the ID of the student to be deleted
     * @return             an InstructorResponseDTO representing the deletion result
     */
    @Override
    public InstructorResponseDTO deleteStudent(UUID studentId) throws StudentExceptions {
        return null;
    }
}
