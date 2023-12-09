package com.example.eatathome.web;

import com.example.eatathome.model.dto.RestaurantDTO;
import com.example.eatathome.model.dto.UserDTO;

import com.example.eatathome.service.Impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") String id) {
        Optional<UserDTO> user = userService.getUserById(id);

        if(user.isEmpty()) return ResponseEntity.notFound().build();
         return ResponseEntity.ok(user.get());

    }


    @GetMapping("email/{email}")
    public ResponseEntity<UserDTO> getByEmail(@PathVariable("email") String email){
        Optional<UserDTO> user = userService.getUserByEmail(email);
        if(user.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.get());
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder){

        String userID = userService.createUser(userDTO);

        URI location = uriComponentsBuilder.path("/users/{id}").buildAndExpand(userID).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") String id, @RequestBody UserDTO updatedUser){
        updatedUser.setId(id);
        Optional<UserDTO> updateUserForReturn = userService.updateUser(updatedUser);
        return ResponseEntity.ok(updateUserForReturn.get());
    }



}
