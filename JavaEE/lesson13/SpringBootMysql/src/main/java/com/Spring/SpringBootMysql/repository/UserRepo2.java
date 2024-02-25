package com.Spring.SpringBootMysql.repository;

import com.Spring.SpringBootMysql.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo2 extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
