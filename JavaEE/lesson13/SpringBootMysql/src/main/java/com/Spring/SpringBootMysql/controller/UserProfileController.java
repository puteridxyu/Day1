package com.Spring.SpringBootMysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import com.Spring.SpringBootMysql.model.UserProfile;
import com.Spring.SpringBootMysql.service.UserProfileService;

@RestController
@RequestMapping("/userProfiles")
@Controller
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    // CREATE
    @PostMapping("/add")
    public UserProfile addUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.addUserProfile(userProfile);
    }

    @PostMapping("/addMultiple")
    public Iterable<UserProfile> addMultiUserProfile(@RequestBody List<UserProfile> userProfileList) {
        return userProfileService.addMultiUserProfile(userProfileList);
    }

    // READ
    @GetMapping("/getAllInfo")
    public Iterable<UserProfile> getAllUserProfiles() {
        return userProfileService.getAllUserProfiles();
    }

    @GetMapping("/getInfo/{id}") // by id
    public Optional<UserProfile> getAllUserProfileById(@PathVariable Long id) {
        return userProfileService.getUserProfileById(id);
    }

    @GetMapping("/getInfo/UserId/{userId}") // Inter Table (users(foreign key), user_profiles)
    public List<UserProfile> getUserProfileByUserId(@PathVariable Long userId) {
        return userProfileService.getUserProfileByUserId(userId);
    }

    // UPDATE
    @PutMapping("/update-bio-by-id/{id}")
    public UserProfile updateBioById(@PathVariable Long id, @RequestBody Map<String, String> bioMap) {
        return userProfileService.updateBioById(id, bioMap);
    }

    @PutMapping("/update-name-by-id/{id}")
    public UserProfile updateNameById(@PathVariable Long id, @RequestBody Map<String, String> nameMap) {
        return userProfileService.updateNameById(id, nameMap);
    }

    // DELETE
    @DeleteMapping("/delete-user-profile-by-id")
    public String deleteUserProfileById(@RequestParam Long id) {
        return userProfileService.deleteUserProfileById(id);
    }

    @DeleteMapping("/delete-user-profile-by-user-id")
    public String deleteUserProfileByUserId(@RequestParam Long userId) {
        return userProfileService.deleteUserProfileByUserId(userId);
    }

}
