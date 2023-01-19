package com.junit.mockito.service;

import com.junit.mockito.dto.UserDto;
import com.junit.mockito.model.User;
import com.junit.mockito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> usuarios = userRepository.findAll();
        return usuarios;
    }

    @Override
    public User getUserByDocument(Integer id) {
        User user = userRepository.findByDocumentNumber(id);
        if (user == null){
            throw new RuntimeException("No se encuentra el usuario registrado");
        }
        return user;
    }

    @Override
    public Object createUsers(UserDto user) {
        User user1 = User.builder()
                .documentType(user.getDocumentType())
                .documentNumber(user.getDocumentNumber())
                .status(true)
                .name(user.getName())
                .lastName(user.getLastName())
                .build();
        userRepository.save(user1);
        return user1;
    }

    @Override
    public User updateUser(UserDto userDto) {
        User user = userRepository.findByDocumentNumber(userDto.getDocumentNumber());
        if (Objects.isNull(user))
            throw new RuntimeException("No se encuentra el usuario registrado");
        user.setDocumentType(user.getDocumentType());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        userRepository.save(user);
        return user;
    }

}
