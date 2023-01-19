package com.junit.mockito.service;

import com.junit.mockito.dto.UserDto;
import com.junit.mockito.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByDocument(Integer id);

    Object createUsers(UserDto user);

    User updateUser(UserDto userDto);

}
