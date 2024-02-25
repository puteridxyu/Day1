package com.Spring.SpringBootMysql.service;

import com.Spring.SpringBootMysql.model.User;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service()
public interface UserService {

    // CREATE
    User addUser(User user);

    Iterable<User> addMultiUser(List<User> userList);

    // READ
    Iterable<User> getAllUsers();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    List<Map<String, String>> getAccountInfoById(Long id);

    User updateUsernameById(Long id, String username);


    User updateEnabledByEmail(Map<String, String> map, Boolean enabled);

    // DELETE
    String deleteUserById(Long id);

}
