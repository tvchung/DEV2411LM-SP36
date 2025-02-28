package com.devmaster.lesson04.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {
    private String name;
    private String email;
    private int age;
}
