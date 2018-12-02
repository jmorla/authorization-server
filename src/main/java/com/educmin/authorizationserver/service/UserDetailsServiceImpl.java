package com.educmin.authorizationserver.service;

import com.educmin.authorizationserver.domain.Authority;
import com.educmin.authorizationserver.domain.User;
import com.educmin.authorizationserver.repository.AuthorityRepository;
import com.educmin.authorizationserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Jorge L. Morla
 * @version 1
 * @since 1
 *
 * class used to authenticate a user
 * */
@Service("userDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * Managed dependency UserRepository
     * */
    @Autowired
    private UserRepository userRepository;

    /**
     * Managed dependency AuthorityRepository
     * */
    @Autowired
    private AuthorityRepository authorityRepository;

    /**
     * @param username
     * @return UserDetails
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username==null && username.isEmpty())
            throw new IllegalArgumentException("username cannot be null or empty");

        Optional<User> refUser = userRepository.findByUsername(username);

        if(!refUser.isPresent())
            throw new UsernameNotFoundException(username);

        List<SimpleGrantedAuthority> authorities = authorityRepository.findAllByUsername(username)
                .stream().map(UserDetailsServiceImpl::mapAuthority).collect(Collectors.toList());

        return refUser.map(e ->
            new org.springframework.security.core.userdetails.User(e.getUsername(),
                    e.getPassword(), authorities)
        ).get();
    }

    /**
     * @param authority
     * @return SimpleGrantedAuthority
     * */
    private static SimpleGrantedAuthority mapAuthority(Authority authority){
        return new SimpleGrantedAuthority(authority.getName());
    }
}
