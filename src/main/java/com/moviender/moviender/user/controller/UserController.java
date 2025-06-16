package com.moviender.moviender.user.controller;

import com.moviender.moviender.user.dto.UserCreateDto;
import com.moviender.moviender.user.dto.UserResponseDto;
import com.moviender.moviender.user.dto.UserUpdateDto;
import com.moviender.moviender.user.repository.UserRepository;
import com.moviender.moviender.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    UserResponseDto createNewUser(@RequestBody UserCreateDto userCreateDto){
        return userService.createUser(userCreateDto);
    }

    @PutMapping("/update")
    ResponseEntity<String> updateUser(@RequestBody UserUpdateDto userUpdateDto){
        try {
            userService.updateUser(userUpdateDto);
            return ResponseEntity.ok("User updated successfully");
        } catch(RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Update failed: " +e.getMessage());
        }
    }

}
