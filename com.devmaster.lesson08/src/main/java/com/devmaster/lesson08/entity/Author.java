package com.devmaster.lesson08.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    public String imgUrl;
    private String email;
    private String phone;
    private String address;
    private Boolean isActive;

    // Tạo mối quan hệ với bảng book
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();
}
