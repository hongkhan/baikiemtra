package com.QLNS._2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User  implements UserDetail {

    @Id
    @GeneratedValue
    private  Long id;

    @Column(name = "username",length = 50,unique = true)
    @NotBlank(message = "Username is required")
    @Size(min = 1, max = 50, message = "Username must between 1 and 50 characters")
    private String username;

    @Column(name = "password",length = 50, unique = true)
    @NotBlank(message = "Password is required")
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(name = "email",length = 50,unique = true)
    @NotBlank(message = "email is required")
    private String email;

    @Column(name = "phone",length = 10,unique = true)
    @Length(min = 10,max = 10,message = "phone must be 10 character")
    @Pattern(regexp = "^[0-9]*$",message = "Phone must be number")
    private String phone;
}
