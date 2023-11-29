package com.example.eatathome.service.Inter;

import com.example.eatathome.model.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> getUserById(String id);
    Optional<UserDTO> getUserByEmail(String email);
    String createUser(UserDTO userDTO);
    void deleteUser(String id);
    Optional<UserDTO> updateUser(UserDTO userDTO);
}
