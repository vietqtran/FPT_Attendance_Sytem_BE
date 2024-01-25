package com.fas.models.dtos.responses;

import com.fas.models.entities.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class StudentResponseDTO {
    private UUID id;

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

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public StudentResponseDTO(Student student) {
        this.id = student.getId();
        this.email = student.getEmail();
        this.studentCode = student.getStudentCode();
        this.username = student.getUsername();
        this.firstName = student.getFirstName();
        this.middleName = student.getMiddleName();
        this.lastName = student.getLastName();
        this.profileImage = student.getProfileImage();
        this.phone = student.getPhone();
        this.address = student.getAddress();
        this.birthDay = student.getBirthDay();
        this.createAt = student.getCreateAt();
        this.updateAt = student.getUpdateAt();
        this.status = student.isStatus();
    }
}
