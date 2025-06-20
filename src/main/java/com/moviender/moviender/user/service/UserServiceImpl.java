package com.moviender.moviender.user.service;

import com.moviender.moviender.user.dto.UserCreateDto;
import com.moviender.moviender.user.dto.UserUpdateDto;
import com.moviender.moviender.user.dto.UserResponseDto;
import com.moviender.moviender.user.model.User;
import com.moviender.moviender.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserCreateDto createDto)
    {
        if(userRepository.existsByUsername(createDto.getUsername()))
            throw new RuntimeException("Username is in use!");

        User user = new User();
        user.setUsername(createDto.getUsername());
        user.setPassword(createDto.getPassword());
        user.setEmail(createDto.getEmail());
        user.setAge(createDto.getAge());

        userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setAge(user.getAge());

        return userResponseDto;
    }

    // TODO: Mevcut kullanıcı bilgisi jwt ile alınacak!!!
    @Override
    public void updateUser(UserUpdateDto updateDto) {

        if(userRepository.existsByUsername(updateDto.getUsername()))
        {
            User user = userRepository.findByUsername(updateDto.getUsername());
            if(updateDto.getUsername() != null)
                user.setUsername(updateDto.getUsername());
            if(updateDto.getPassword() != null)
                user.setPassword(updateDto.getPassword());
            if(updateDto.getEmail() != null)
                user.setEmail(updateDto.getEmail());
            if(updateDto.getAge() != null)
                user.setAge(updateDto.getAge());

            userRepository.save(user);
        }
        else
            throw new RuntimeException("Username cannot be found!!!");
    }
}
