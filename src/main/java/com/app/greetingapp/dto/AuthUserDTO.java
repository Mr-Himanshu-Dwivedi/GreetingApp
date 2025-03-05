package com.app.greetingapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import static org.springframework.security.config.http.MatcherType.regex;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//UC 9
public class AuthUserDTO {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
//    @Size(min = 0,message = "Password must be atleast 8 character")
//    @Pattern(regex)
    private String password;
}
