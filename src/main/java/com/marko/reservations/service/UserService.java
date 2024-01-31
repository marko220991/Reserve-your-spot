package com.marko.reservations.service;

import com.marko.reservations.exception.EntityNotFoundException;
import com.marko.reservations.model.User;
import com.marko.reservations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user;
        }
        throw new EntityNotFoundException("User with id " + id + " not found in database!");
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User userToUpdate = optionalUser.get();

            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setSecondName(user.getSecondName());
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setEmail(user.getEmail());

            return userRepository.save(userToUpdate);
        }
        throw new EntityNotFoundException("User with id " + id + " not found in database so it cannot be updated!");
    }

    public void deleteUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User userToDelete = optionalUser.get();
            userRepository.delete(userToDelete);
        }
        throw new EntityNotFoundException("User with id " + id + " not found in database!");
    }
}
