package com.Spring.SpringBootMysql.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.Spring.SpringBootMysql.model.UserProfile;

@Service()
public interface UserProfileService {

    // CREATE
    UserProfile addUserProfile(UserProfile userProfile);
    Iterable<UserProfile> addMultiUserProfile(List<UserProfile> userProfileList);
    
    // READ
    Iterable<UserProfile> getAllUserProfiles();
    Optional<UserProfile> getUserProfileById(Long id);
    List<UserProfile> getUserProfileByUserId(Long userId);

    // UPDATE
    UserProfile updateBioById(Long id, Map<String,String> bioMap);
    UserProfile updateNameById(Long userId, Map<String,String> nameMap);

    //DELETE 
    String deleteUserProfileById(Long id);
    String deleteUserProfileByUserId(Long userId);

}
