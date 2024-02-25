package com.Spring.SpringBootMysql.service;

import com.Spring.SpringBootMysql.model.UserPermission;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service()
public interface UserPermissionService {

    // READ
    Optional<UserPermission> getUserPermissionByUserId(Long id);

}