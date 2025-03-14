package com.devmaster.lesson07.com.devmaster.lesson07.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Họ và tên không để trống")
    @Size(min = 3,message = "Họ và tên có tôí thiểu 3 ký tự")
    private String fullName;

    @NotBlank(message = "Tài khoản không để trống")
    @Size(min = 3, message = "Tài khoản có tối thiểu 3 ký tự")
    @Column(unique = true)
    private String userName;

    @NotBlank(message = "Mật khẩu không để trống")
    @Size(min = 6, message = "Mật khẩu có ít nhất 6 ký tự")
    private String password;

    @NotBlank(message = "Email không để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$",message = "Điện thoại chỉ chứa ký tự số; độ dài trong khoảng 10 - 15")
    private String phone;

    private String address;
    private Boolean isActive;
}
