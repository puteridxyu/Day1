package com.Spring.SpringBootMysql.service.serviceImpl;

import com.Spring.SpringBootMysql.model.Permission;
import com.Spring.SpringBootMysql.model.User;
import com.Spring.SpringBootMysql.model.UserPermission;
import com.Spring.SpringBootMysql.model.UserProfile;
import com.Spring.SpringBootMysql.repository.UserRepo;

import com.Spring.SpringBootMysql.service.PermissionService;
import com.Spring.SpringBootMysql.service.UserPermissionService;
import com.Spring.SpringBootMysql.service.UserProfileService;
import com.Spring.SpringBootMysql.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserPermissionService userPermissionService;

    // CREATE
    @SuppressWarnings("null")
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    @Override
    public Iterable<User> addMultiUser(List<User> userList) {
        return userRepository.saveAll(userList);
    }

    // READ
    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Demo on connection between tables
    @SuppressWarnings("null")
    @Override
    public List<Map<String, String>> getAccountInfoById(Long id) {
        List<Map<String, String>> res = new ArrayList<>();
        Optional<User> userOptional = userRepository.findById(id);
        Optional<UserPermission> userPermissionOptional = userPermissionService.getUserPermissionByUserId(id);

        if (userOptional.isPresent()) {
            if (userPermissionOptional.isPresent()) {

                UserPermission userPermission = userPermissionOptional.get();
                User user = userOptional.get();
                Optional<Permission> permissionOptional = permissionService
                        .getPermissionById(userPermission.getPermissionId());

                if (permissionOptional.isPresent()) {
                    Permission permission = permissionOptional.get();
                    List<UserProfile> userProfileList = userProfileService.getUserProfileByUserId(id);

                    for (int i = 0; i < userProfileList.size(); i++) {
                        Map<String, String> tempMap = new HashMap<>();

                        tempMap.put("username", user.getUsername());
                        tempMap.put("firstName", userProfileList.get(i).getFirstName());
                        tempMap.put("lastName", userProfileList.get(i).getLastName());
                        tempMap.put("permission", permission.getName());
                        res.add(tempMap);
                    }
                    return res;
                }

            }
        }

        return null;
    }

    // UPDATE
    @SuppressWarnings("null")
    @Override
    public User updateUsernameById(Long id, String username) {
        Optional<User> userToUpdateOptional = userRepository.findById(id);
        if (userToUpdateOptional.isPresent()) {
            User userToUpdate = userToUpdateOptional.get();
            userToUpdate.setUsername(username);
            return userRepository.save(userToUpdate);
        }
        return null;
    }

    @Override
    public User updateEnabledByEmail(Map<String, String> map, Boolean enabled) {
        Optional<User> userToUpdateOptional = userRepository.findByEmail(map.get("email"));
        if (userToUpdateOptional.isPresent()) {
            User userToUpdate = userToUpdateOptional.get();
            userToUpdate.setEnabled(enabled);
            return userRepository.save(userToUpdate);
        }
        return null;
    }

    // DELETE
    @SuppressWarnings("null")
    @Override
    public String deleteUserById(Long id) {
        Optional<User> userToDeleteOptional = userRepository.findById(id);

        if (userToDeleteOptional.isPresent()) {
            User userToDelete = userToDeleteOptional.get();
            userRepository.delete(userToDelete);
            return String.format("User with id %d successfully deleted!", userToDelete.getId());
        }
        return String.format("User not found!");
    }

}
