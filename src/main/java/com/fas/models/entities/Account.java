package com.fas.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private String email;

    @NotBlank(message = "Password must not be blank")
    private String password;

    @NotBlank(message = "Username must not be blank")
    private String username;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @NotNull(message = "Role must not be null")
    private Role role;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public Account(UUID id, String email, String password, String username, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
