package com.moviender.moviender.user.service;

import com.moviender.moviender.user.dto.UserCreateDto;
import com.moviender.moviender.user.dto.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void createUser_shouldReturnUserResponseDto(){
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername("Myrina");
        userCreateDto.setPassword("Myrina.1234");
        userCreateDto.setEmail("Myrina@gmail.com");
        userCreateDto.setAge(25);

        UserResponseDto result = userServiceImpl.createUser(userCreateDto);

        assertEquals(result.getUsername(), userCreateDto.getUsername());
        assertEquals(result.getEmail(), userCreateDto.getEmail());
        assertEquals(result.getAge(), userCreateDto.getAge());
    }

}
