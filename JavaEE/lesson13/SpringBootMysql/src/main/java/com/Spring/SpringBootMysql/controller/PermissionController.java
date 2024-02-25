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

import com.Spring.SpringBootMysql.model.Permission;
import com.Spring.SpringBootMysql.service.PermissionService;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
@Controller
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    // CREATE
    @PostMapping("/add")
    public Permission addPermission(@RequestBody Permission permission) {
        return permissionService.addPermission(permission);
    }

    // READ
    @GetMapping
    public Iterable<Permission> getAllPermission() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/{id}")
    public Optional<Permission> getPermissionById(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }

    // UPDATE
    @PutMapping("/updateName/{id}") // by id
    public Permission updateNameById(@PathVariable Long id, @RequestParam String name) {
        return permissionService.updateNameById(id, name);
    }

    // DELETE
    @DeleteMapping("/delete") // by id
    public String deleteUserById(@RequestParam Long id) {
        return permissionService.deletePermissionById(id);
    }

}
