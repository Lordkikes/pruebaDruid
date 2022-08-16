package com.pruebadruid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

import static org.apache.coyote.http11.Constants.a;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The Name cannot be empty")
    @Pattern(regexp = "[a-zA-z]+([ '-][a-zA-Z]+)*")
    private String name;

    @NotEmpty(message = "The Lastname cannot be empty")
    @Pattern(regexp = "[a-zA-z]+([ '-][a-zA-Z]+)*")
    private String lastName;

    @Email(message = "Email is not valid")
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z0-9]+[a-zA-Z0-9_-]*@[a-zA-Z]+\\p{Punct}[a-zA-Z]+")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$")
    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate  birthDate;

    public UserEntity(String name, String lastName, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }
}
