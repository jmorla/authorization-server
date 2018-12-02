package com.educmin.authorizationserver.repository;

import com.educmin.authorizationserver.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    /**
     * @param username
     * @return List<Authority> list of authorities
     * */
    @Query("select a from Authority a join a.users u where u.username = :username")
    List<Authority> findAllByUsername(@Param("username") String username);
}
