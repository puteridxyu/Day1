package com.Spring.SpringBootMysql.service.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.SpringBootMysql.model.Permission;
import com.Spring.SpringBootMysql.repository.PermissionRepo;
import com.Spring.SpringBootMysql.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepo permissionRepository;

    // CREATE
    @SuppressWarnings("null")
    @Override
    public Permission addPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    // READ
    @Override
    public Iterable<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Permission> getPermissionById(Long id) {
        return permissionRepository.findById(id);
    }

    @SuppressWarnings("null")
    @Override
    public Permission updateNameById(Long id, String name) {
        Optional<Permission> permissionToUpdateOptional = permissionRepository.findById(id);
        if (permissionToUpdateOptional.isPresent()) {
            Permission permissionToUpdate = permissionToUpdateOptional.get();
            permissionToUpdate.setName(name);
            return permissionRepository.save(permissionToUpdate);
        }
        return null;
    }

    @SuppressWarnings("null")
    @Override
    public String deletePermissionById(Long id) {
        Optional<Permission> permissionToDeleteOptional = permissionRepository.findById(id);

        if (permissionToDeleteOptional.isPresent()) {
            Permission permissionToDelete = permissionToDeleteOptional.get();
            permissionRepository.delete(permissionToDelete);
            return String.format("Permission with id %d successfully deleted!", permissionToDelete.getId());
        }

        return String.format("Permission not found!");
    }
}
