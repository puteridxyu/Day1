package com.Spring.SpringBootMysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Spring.SpringBootMysql.model.UserPermission;

import java.util.Optional;

@Repository
public interface UserPermissionRepo extends CrudRepository<UserPermission, Long> {

    Optional<UserPermission> findByUserId(Long id);

}
