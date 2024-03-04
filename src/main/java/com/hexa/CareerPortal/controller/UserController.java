package com.hexa.CareerPortal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping //checked
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")  //checked
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) throws ResourceNotFoundException {
        UserDTO userDTO = userService.findByUserId(userId);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
    }

    @PutMapping("/{userId}") //checked
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO userDTO) throws ResourceNotFoundException {
        UserDTO updatedUser = userService.updateUser(userId, userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        else
        {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
    }

    @DeleteMapping("/{userId}")  //checked
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws ResourceNotFoundException {
        User user=userService.deleteById(userId);
        if(user!=null)
        {
        	return ResponseEntity.noContent().build();
        }
        else
        {
        	throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        
    }

    @GetMapping  //checked
    public ResponseEntity<List<UserDTO>> getAllUsers() throws ResourceNotFoundException {
        List<UserDTO> users = userService.findAll();
        //System.out.println(""+users.toString());
        if(users!=null)
        {
        	return ResponseEntity.ok(users);
        }
        else
        {
        	throw new ResourceNotFoundException("Users not found with id: ");
        }
    }


    @PostMapping("/createMultiple")  //checked
    public ResponseEntity<List<UserDTO>> createUsers(@Valid @RequestBody List<UserDTO> users) {
        List<UserDTO> createdUsers = userService.createUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsers);
    }


    @GetMapping("/findByName")  //checked
    public ResponseEntity<List<UserDTO>> findByName(@RequestParam String name) throws ResourceNotFoundException {
        List<UserDTO> userDTO=userService.findByName(name);
        if(!userDTO.isEmpty())
        {
        	return ResponseEntity.ok(userDTO); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }

    @GetMapping("/findByEmail") 
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) throws ResourceNotFoundException {
        UserDTO user=userService.findByEmail(email);
        if(user!=null)
        {
        	return ResponseEntity.ok(user); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }

    @GetMapping("/findByRole")
    public ResponseEntity<List<UserDTO>> findByRole(@RequestParam Role role) throws ResourceNotFoundException {
        List<UserDTO> userDTOs= userService.findByRole(role);
        if(!userDTOs.isEmpty()) {
        	return ResponseEntity.ok(userDTOs); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }

    @GetMapping("/findByNameContaining")
    public ResponseEntity<List<UserDTO>> findByNameContaining(@RequestParam String name) throws ResourceNotFoundException {
    	List<UserDTO> userDTOs= userService.findByNameContaining(name);
        if(!userDTOs.isEmpty()) {
        	return ResponseEntity.ok(userDTOs); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }

    @GetMapping("/findByNameIn")
    public ResponseEntity<List<UserDTO>> findByNameIn(@RequestBody List<String> names) throws ResourceNotFoundException {
    	List<UserDTO> userDTOs=userService.findByNameIn(names);
        if(!userDTOs.isEmpty()) {
        	return ResponseEntity.ok(userDTOs); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllUsers() throws ResourceNotFoundException {
    	List<UserDTO> userDTOs=userService.deleteAll();
        if(!userDTOs.isEmpty()) {
        	return ResponseEntity.noContent().build(); 
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        long count= userService.count();
        return ResponseEntity.ok(count);
    }


    @PutMapping("/updateName/{id}")
    public ResponseEntity<UserDTO> updateName(@PathVariable Long id, @RequestBody String name) throws ResourceNotFoundException {
    	UserDTO userDTO=userService.updateName(id, name);
        if(userDTO!=null) {
        	return ResponseEntity.ok(userDTO);
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }

    }

    @PutMapping("/updateEmail/{id}")
    public ResponseEntity<UserDTO> updateEmail(@PathVariable Long id, @RequestBody String email) throws ResourceNotFoundException {
        UserDTO userDTO= userService.updateEmail(id, email);
        if(userDTO!=null) {
        	return ResponseEntity.ok(userDTO);
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }

    @PutMapping("/changePassword/{id}")
    public ResponseEntity<User> changePassword(@PathVariable Long id, @RequestBody String password) throws ResourceNotFoundException {
        User user= userService.changePassword(id, password);
        if(user!=null) {
        	return ResponseEntity.ok(user);
        }
        else
        {
        	throw new ResourceNotFoundException("user is not found");
        }
    }
}
