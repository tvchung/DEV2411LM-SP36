package com.devmaster.crudValid.entity;
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
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Họ và tên không được để trống")
    @Size(min = 3, message = "Họ và tên phải ít nhất 3 ký tự")
    private String fullName;
    @NotBlank(message = "Tài khoản không được để trống")
    @Size(min = 3, message = "Tài khoản phải ít nhất 3 ký tự")
    @Column(unique = true, nullable = false)
    private String userName;
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải ít nhất 6 ký tự")
    private String password;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Điện thoại phải chứa ký tự số có độ dài trong khoảng 10 - 15")
    private String phone;
    private String address;
    private Boolean isActive;
}
