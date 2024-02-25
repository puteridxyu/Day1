package com.Spring.SpringBootMysql.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.Spring.SpringBootMysql.model.Permission;

@Service()
public interface PermissionService {

    // CREATE
    Permission addPermission(Permission permission);

    // READ
    Iterable<Permission> getAllPermissions();

    Optional<Permission> getPermissionById(Long id);

    // UPDATE
    Permission updateNameById(Long id, String name);

    // DELETE
    String deletePermissionById(Long id);

}
