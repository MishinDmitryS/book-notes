package com.dm.bookwithnotes.repositories;

import com.dm.bookwithnotes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
