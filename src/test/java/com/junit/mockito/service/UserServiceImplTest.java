package com.junit.mockito.service;

import com.junit.mockito.model.User;
import com.junit.mockito.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    /**
     * 1.Given -> agregar configuracion o precondiones
     * 2.When -> Es la accion o el comportamiento
     * 3.Then -> verificar salida
     */
    @Test
    void getAllUsers() {
    }

    @Test
    void getUserByDocument() {
        Integer documento = 2222222;
        User user = User.builder()
                .name("Manuel")
                .documentType("CC")
                .build();
        Mockito.when(userRepository.findByDocumentNumber(documento)).thenReturn(user);
        Assertions.assertNotNull(userService.getUserByDocument(documento));
    }

    @Test
    void getUserByDocumentTest2() {
        Mockito.when(userRepository.findByDocumentNumber(Mockito.any(Integer.class))).thenReturn(null);
        Assertions.assertThrows(RuntimeException.class, ()-> userService.getUserByDocument(Mockito.any(Integer.class)), "No se encuentra el usuario registrado");
    }

    @ParameterizedTest
    @MethodSource("sourceDocument")
    void getUserByDocumentTest(String esenario){
        Integer documento = 2222222;
        User user = User.builder()
                .name("Manuel")
                .documentType("CC")
                .build();
        if (esenario.equals("correct")){
            Mockito.when(userRepository.findByDocumentNumber(documento)).thenReturn(user);
            Assertions.assertNotNull(userService.getUserByDocument(documento));
            Assertions.assertEquals("Manuel", user.getName());
        }else if (esenario.equals("exception")){
            Mockito.when(userRepository.findByDocumentNumber(Mockito.any(Integer.class))).thenReturn(null);
            Assertions.assertThrows(RuntimeException.class, ()-> userService.getUserByDocument(Mockito.any(Integer.class)), "No se encuentra el usuario registrado");
        }
    }

    private static Stream<Arguments> sourceDocument(){
        return Stream.of(
                Arguments.arguments("correct"),
                Arguments.arguments("exception")
        );
    }

    @Test
    void createUsers() {
    }

    @Test
    void updateUser() {
    }
}