package ru.altacod.prmo.controller;

import org.springframework.web.bind.annotation.*;
import ru.altacod.prmo.DTO.UserDTO;
import ru.altacod.prmo.model.User;
import ru.altacod.prmo.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(Long id) {
        return userService.getUserById(id);
    }


    @PostMapping
    public User addUser(@RequestBody UserDTO user) {
        User userEntity= userService.toEntity(user);
        return userService.createUser(userService.toDTO(userEntity));
    }

    @PutMapping
    public User updateUser(@RequestBody Long id, UserDTO user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

