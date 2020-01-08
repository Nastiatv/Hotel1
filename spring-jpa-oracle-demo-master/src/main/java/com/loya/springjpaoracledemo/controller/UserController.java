package com.loya.springjpaoracledemo.controller;

import com.loya.springjpaoracledemo.entity.User;
import com.loya.springjpaoracledemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }


    @PostMapping(value = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }


    @PutMapping(value = "/updateuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @DeleteMapping(value = "/all")
    public void deleteAllUsers() {
        this.userService.deleteAllUsers();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUserById(id);
    }

    @Autowired
    MessageSource messageSource;

    @GetMapping(value = "/get-greeting")
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given user context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a user-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @GetMapping(value = "/get-greeting-name")
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiloya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}
