package com.moviender.moviender.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data //@Getter - @Setter

public class UserCreateDto {
    @NotNull(message = "Username cannot be null!")
    private String username;

    @ToString.Exclude
    @Size(min=8, max=15, message = "Password must be between 8 and 15 characters")
    private String password;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Age cannot be null!")
    @Positive
    private Integer age;
}
