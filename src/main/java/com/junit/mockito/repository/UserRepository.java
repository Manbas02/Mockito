package com.junit.mockito.repository;

import com.junit.mockito.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByDocumentNumber (Integer documentNumber);

    User deleteUserByDocumentNumber (Integer documentNumber);

}
