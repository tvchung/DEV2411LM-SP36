package com.devmaster.lesson06.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")  // Store UUID as binary in the database
    private UUID id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "isactive")
    private boolean isactive;

}
