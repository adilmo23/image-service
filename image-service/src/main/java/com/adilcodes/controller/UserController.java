package com.adilcodes.controller;

import com.adilcodes.Exception.UserDetailsEmptyException;
import com.adilcodes.Exception.UserNameNotFoundException;
import com.adilcodes.entity.User;
import com.adilcodes.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) throws UserDetailsEmptyException {
        return userService.createUser(user);
    }

    @GetMapping("/login")
    public ResponseEntity<User> getByUserName(@RequestBody User user) throws UserNameNotFoundException {
        if (user.getUserName() != null) {
            return ResponseEntity.ok().body(userService.getByUserName(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allUsers")
    public ResponseEntity<User> getAllUsers() {
        return (ResponseEntity<User>) userService.findAllUsers();
    }

    @DeleteMapping("/remove/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "User deleted with" + id;
    }

}
