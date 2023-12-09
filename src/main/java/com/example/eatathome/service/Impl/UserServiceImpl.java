package com.example.eatathome.service.Impl;
import com.example.eatathome.model.dto.UserDTO;
import com.example.eatathome.model.entity.User;
import com.example.eatathome.repository.UserRepository;
import com.example.eatathome.service.Inter.UserService;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<UserDTO> getUserById(String id){
        return this.userRepository.findUserById(id).map(this::asDTO);
    }

    private UserDTO asDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email){
        return this.userRepository.findUserByEmail(email).map(this::asDTO);
    }


    @Override
    public String createUser(UserDTO userDTO) {
        // TODO: email validation for exisitng
        User newUser = new User().setFirstName(userDTO.getFirstName()).setLastName(userDTO.getLastName()).
                setEmail(userDTO.getEmail()).setPassword(userDTO.getPassword()).setId(UUID.randomUUID().toString());

        return this.userRepository.save(newUser).getId();
    }

    @Override
    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDTO> updateUser(UserDTO userDTO) {
        if(!this.userRepository.existsById(userDTO.getId())){
            throw new EntityNotFoundException("Entity with ID " + userDTO.getId() + " not found");
        }

        this.userRepository.save(this.modelMapper.map(userDTO,User.class));
        return userRepository.findUserById(userDTO.getId()).map(this::asDTO);
    }
}
