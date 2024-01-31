package com.marko.reservations.controller;

import com.marko.reservations.exception.UserNotFoundException;
import com.marko.reservations.model.User;
import com.marko.reservations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.getUsers();
    }
    @GetMapping(params = "id")
    public Optional<User> findById(@RequestParam("id") long id) {
        return userService.getById(id);
    }
    @PostMapping("/add")
    public User saveNewUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PutMapping(value = "/update", params = "id")
    public User updateUser(@RequestBody User user,@RequestParam("id") long id) {
        return userService.updateUser(user, id);
    }
    @DeleteMapping(value = "/delete", params = "id")
    public void removeUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
    }
}
