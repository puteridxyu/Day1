package com.Spring.SpringBootMysql.controller;

import com.Spring.SpringBootMysql.model.User;
import com.Spring.SpringBootMysql.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    // CREATE
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/addMultiple")
    public Iterable<User> addUser(@RequestBody List<User> userList) {
        return userService.addMultiUser(userList);
    }

    // READ
    @GetMapping("/getAll")
    public Iterable<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/getInfo/{id}") // by id
    public List<Map<String, String>> getAccountInfoById(@PathVariable Long id) {
        return userService.getAccountInfoById(id);
    }

    // UPDATE
    @PutMapping("/updateUsername/{id}") // by id
    public User updateUsernameById(@PathVariable Long id, @RequestParam String username) {
        return userService.updateUsernameById(id, username);
    }

    @PutMapping("/updateEnabled/email")
    public User updateEnabledByEmail(@RequestBody Map<String, String> map, @RequestParam Boolean enabled) {
        return userService.updateEnabledByEmail(map, enabled);
    }

    // DELETE
    @DeleteMapping("/deleteUser") // by id
    public String deleteUserById(@RequestParam Long id) {
        return userService.deleteUserById(id);
    }

}
