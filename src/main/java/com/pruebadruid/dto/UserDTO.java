package com.pruebadruid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;

    private String lastName;

    private String email;

    private String password;

    private LocalDate birthDate;
}
