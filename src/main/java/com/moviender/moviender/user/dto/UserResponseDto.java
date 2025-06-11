package com.moviender.moviender.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseDto {

    private String username;
    private String email;
    private Integer age;

}
