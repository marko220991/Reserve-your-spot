package com.marko.reservations.controller;

import com.marko.reservations.model.User;
import com.marko.reservations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveNewUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
