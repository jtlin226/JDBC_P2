package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    User findUserById(@PathVariable String id) {
        return userService.getUserById(Integer.parseInt(id));
    }

    @GetMapping("/username/{username}")
    public @ResponseBody
    User findUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public @ResponseBody
    String createUser(@RequestBody User user) {
        userService.saveUser(user);
        return "home";
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        if(userService.deleteUse(Integer.parseInt(id))) {
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public @ResponseBody
    User updateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
