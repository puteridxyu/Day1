package com.Spring.SpringBootMysql.service.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.SpringBootMysql.model.UserProfile;
import com.Spring.SpringBootMysql.repository.UserProfileRepo;
import com.Spring.SpringBootMysql.service.UserProfileService;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepo userProfileRepository;

    // CREATE
    @SuppressWarnings("null")
    @Override
    public UserProfile addUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @SuppressWarnings("null")
    @Override
    public Iterable<UserProfile> addMultiUserProfile(List<UserProfile> userProfileList) {
        return userProfileRepository.saveAll(userProfileList);
    }

    // READ
    @Override
    public Iterable<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<UserProfile> getUserProfileById(Long id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public List<UserProfile> getUserProfileByUserId(Long userId) {
        return userProfileRepository.findAllByUserId(userId);
    }

    @SuppressWarnings("null")
    @Override
    public UserProfile updateBioById(Long id, Map<String, String> bioMap) {
        Optional<UserProfile> userProfileToUpdateOptional = userProfileRepository.findById(id);
        if (userProfileToUpdateOptional.isPresent()) {
            UserProfile userProfileToUpdate = userProfileToUpdateOptional.get();
            userProfileToUpdate.setBio(bioMap.get("bio"));
            return userProfileRepository.save(userProfileToUpdate);
        }
        return null;
    }

    @SuppressWarnings("null")
    @Override
    public UserProfile updateNameById(Long id, Map<String, String> nameMap) {
        Optional<UserProfile> userProfileToUpdateOptional = userProfileRepository.findById(id);
        if (userProfileToUpdateOptional.isPresent()) {
            UserProfile userProfileToUpdate = userProfileToUpdateOptional.get();
            System.out.println(nameMap);
            userProfileToUpdate.setFirstName(nameMap.get("firstName"));
            userProfileToUpdate.setLastName(nameMap.get("lastName"));
            return userProfileRepository.save(userProfileToUpdate);
        }
        return null;
    }

    @SuppressWarnings("null")
    @Override
    public String deleteUserProfileById(Long id) {
        Optional<UserProfile> userProfileToDeleteOptional = userProfileRepository.findById(id);

        if (userProfileToDeleteOptional.isPresent()) {
            UserProfile userProfileToDelete = userProfileToDeleteOptional.get();
            userProfileRepository.delete(userProfileToDelete);
            return String.format("User profile with id %d successfully deleted!", userProfileToDelete.getId());
        }
        return String.format("User profile not found!");
    }

    @Override
    public String deleteUserProfileByUserId(Long userId) {
        List<UserProfile> userProfileToDelete = userProfileRepository.findAllByUserId(userId);

        if (!userProfileToDelete.isEmpty()) {
            userProfileRepository.deleteAll(userProfileToDelete);
            return String.format("User profiles with user id %d successfully deleted!", userId);
        }
        return String.format("User profile not found!");
    }

}
