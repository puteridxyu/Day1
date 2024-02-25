package com.Spring.SpringBootMysql.repository;

import com.Spring.SpringBootMysql.model.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends CrudRepository<Permission, Long> {
}