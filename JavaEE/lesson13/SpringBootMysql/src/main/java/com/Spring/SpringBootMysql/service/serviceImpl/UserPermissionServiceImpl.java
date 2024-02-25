package com.Spring.SpringBootMysql.service.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.SpringBootMysql.model.UserPermission;

import com.Spring.SpringBootMysql.repository.UserPermissionRepo;
import com.Spring.SpringBootMysql.service.UserPermissionService;


@Service
@Transactional
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired
    UserPermissionRepo userPermissionRepository;

    @Override
    public Optional<UserPermission> getUserPermissionByUserId(Long id) {
        return userPermissionRepository.findByUserId(id);
    }

}
