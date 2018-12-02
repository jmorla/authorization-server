package com.educmin.authorizationserver.repository;

import com.educmin.authorizationserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Jorge L. Morla
 * @since 1
 * @version 1
 *
 * <h5>Description</h5>
 * class used to retrieve user from database storage
 * */
public interface UserRepository extends JpaRepository<User, String>{

    /**
     * @param username
     * get user by username
     * */
    Optional<User> findByUsername(String username);
}
