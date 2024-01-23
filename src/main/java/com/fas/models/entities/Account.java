package com.fas.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Email(message = "Email must be valid")
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password must not be blank")
    private String password;

    private String username;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @NotNull(message = "Role must not be null")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    @NotNull(message = "Campus must not be null")
    private Campus campus;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Account(String email, String password, Role role, Campus campus) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.campus = campus;
    }

    public Account(String email, Campus campus) {
        this.email = email;
        this.campus = campus;
    }
}
