package com.Spring.SpringBootMysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Spring.SpringBootMysql.model.UserProfile;

import java.util.List;

@Repository
public interface UserProfileRepo extends CrudRepository<UserProfile, Long> {

    List<UserProfile> findAllByUserId(Long id);

}
