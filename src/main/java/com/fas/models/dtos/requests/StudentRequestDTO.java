package com.fas.models.dtos.requests;

import com.fas.models.entities.Student;
import lombok.Data;

import java.util.Date;

@Data
public class StudentRequestDTO {
    private String email;
    private String studentCode;
    private String username;

    private String firstName;

    private String middleName;

    private String lastName;

    private String profileImage;

    private String phone;

    private String address;

    private Date birthDay;



    public Student getStudent() {
        return new Student(email, studentCode, username, firstName, middleName, lastName, profileImage, phone, address, birthDay);
    }
}
