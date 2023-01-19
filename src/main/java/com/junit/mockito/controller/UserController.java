package com.junit.mockito.controller;

import com.junit.mockito.dto.UserDto;
import com.junit.mockito.model.User;
import com.junit.mockito.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/listar")
    public List<?> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/obtener")
    public User getUserByDocument(@RequestHeader(name = "numeroDocumento") Integer documentNumber){
        return userService.getUserByDocument(documentNumber);
    }

    @PostMapping("/crear")
    public User createUser(@RequestBody UserDto userDto){
        return (User) userService.createUsers(userDto);
    }

    @PutMapping("/actualizar")
    public User updateUserData(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

}