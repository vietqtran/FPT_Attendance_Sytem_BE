package com.fas.dtos.requests;

import com.fas.models.entities.Major;
import com.fas.models.entities.Role;
import com.fas.models.entities.Semester;
import com.fas.models.entities.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class StudentRequestDTO {
    private String email;

    private String username;

    private String firstName;

    private String middleName;

    private String lastName;

    private String profileImage;

    private String phone;

    private String address;

    private Date birthDay;



    public Student getStudent() {
        return new Student(email, username, firstName, middleName, lastName, profileImage, phone, address, birthDay);
    }
}
