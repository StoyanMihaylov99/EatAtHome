package com.example.eatathome.model.dto;

import com.example.eatathome.model.entity.Menu;
import java.util.List;
import java.util.Set;

public class UserDTO {

    private String id;
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Set<Menu> menu;

    private List<String> addresses;

    public UserDTO() {
    }

    public String getId() {
        return id;
    }

    public UserDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public UserDTO setMenu(Set<Menu> menu) {
        this.menu = menu;
        return this;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public UserDTO setAddresses(List<String> addresses) {
        this.addresses = addresses;
        return this;
    }
}
