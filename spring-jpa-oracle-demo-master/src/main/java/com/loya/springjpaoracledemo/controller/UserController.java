package com.loya.springjpaoracledemo.controller;

import com.loya.springjpaoracledemo.api.dto.UserDto;
import com.loya.springjpaoracledemo.entity.User;
import com.loya.springjpaoracledemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable int id, @RequestBody User user ) {
        return userService.updateUser(id, user);
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "/")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }

   


}
