package com.moviender.moviender.user.service;

import com.moviender.moviender.user.dto.UserCreateDto;
import com.moviender.moviender.user.dto.UserResponseDto;
import com.moviender.moviender.user.dto.UserUpdateDto;
import com.moviender.moviender.user.model.User;
import com.moviender.moviender.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

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

    @Test
    void updateUser_Success(){
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setUsername("Myrina");
        userUpdateDto.setPassword("Myrina.123");
        userUpdateDto.setEmail("Myrina@gmail.com");
        userUpdateDto.setAge(26);

        User user = new User();
        user.setId(UUID.fromString("076a620e-6f5b-4b4c-874b-4c0c5eda9812"));
        user.setUsername("Myrina");
        user.setPassword("Kolaca.1967");
        user.setEmail("kolacasevval@gmail.com");
        user.setAge(25);

        when(userRepository.existsByUsername(user.getUsername())).thenReturn(true);
        when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

        userServiceImpl.updateUser(userUpdateDto);

        //TODO: ArgumentCaptor ile değiştirilebilir - ileri seviye -
        verify(userRepository).save(Mockito.<User>any());
    }

}
