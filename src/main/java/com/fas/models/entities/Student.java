package com.fas.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@fpt\\.edu\\.vn$", message = "Email must be valid")
    private String email;

    @NotBlank(message = "Username must not be blank")
    private String username;

    @NotBlank(message = "Student Code must not be null")
    private String studentCode;

    @NotBlank(message = "First name must not be blank")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @URL(message = "Profile image must be valid")
    @NotBlank(message = "Profile image must not be blank")
    private String profileImage;

    @NotBlank(message = "Phone number must not be blank")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message = "Address must not be blank")
    private String address;

    @NotNull(message = "Birth day must not be null")
    private Date birthDay;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    private boolean status = true;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Student(String email, String studentCode, String username, String firstName, String middleName, String lastName, String profileImage, String phone, String address, Date birthDay, LocalDateTime createAt, LocalDateTime updateAt, boolean status, UUID majorId) {
        this.email = email;
        this.studentCode = studentCode;
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.profileImage = profileImage;
        this.phone = phone;
        this.address = address;
        this.birthDay = birthDay;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
        this.major = new Major(majorId);
    }
}
