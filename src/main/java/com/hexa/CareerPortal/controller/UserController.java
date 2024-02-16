package com.hexa.CareerPortal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.entity.Role;
import com.hexa.CareerPortal.entity.User;
import com.hexa.CareerPortal.exception.ResourceNotFoundException;
import com.hexa.CareerPortal.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) throws ResourceNotFoundException {
        UserDTO userDTO = userService.findByUserId(userId);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @Validated @RequestBody UserDTO userDTO) throws ResourceNotFoundException {
        UserDTO updatedUser = userService.updateUser(userId, userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }


    @PostMapping("/createMultiple")
    public ResponseEntity<List<UserDTO>> createUsers(@RequestBody List<UserDTO> users) {
        List<UserDTO> createdUsers = userService.createUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsers);
    }


    @GetMapping("/findByName")
    public User findByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/findByRole")
    public List<User> findByRole(@RequestParam Role role) {
        return userService.findByRole(role);
    }

    @GetMapping("/findByNameContaining")
    public List<User> findByNameContaining(@RequestParam String name) {
        return userService.findByNameContaining(name);
    }

    @PostMapping("/findByNameIn")
    public List<User> findByNameIn(@RequestBody List<String> names) {
        return userService.findByNameIn(names);
    }

    @DeleteMapping("/{id}")
    public User deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public List<User> deleteAllUsers() {
        return userService.deleteAll();
    }

    @GetMapping("/count")
    public long count() {
        return userService.count();
    }

    @PostMapping("/deleteAll")
    public List<User> deleteAll(@RequestBody List<User> users) {
        return userService.deleteAll(users);
    }

    @PutMapping("/{id}/updateName")
    public User updateName(@PathVariable Long id, @RequestParam String name) {
        return userService.updateName(id, name);
    }

    @PutMapping("/{id}/updateEmail")
    public User updateEmail(@PathVariable Long id, @RequestParam String email) {
        return userService.updateEmail(id, email);
    }

    @PutMapping("/{id}/changePassword")
    public User changePassword(@PathVariable Long id, @RequestParam String password) {
        return userService.changePassword(id, password);
    }
}
