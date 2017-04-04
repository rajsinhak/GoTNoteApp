package com.gotprint.noteapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotprint.noteapp.entity.User;
import com.gotprint.noteapp.repository.UserRepository;
import com.gotprint.noteapp.security.UserService;

/**
 * @author rkamh
 * @since 04/04/2014
 * Mock implementation.
 */
@Service
public class DatabaseUserService implements UserService {
    private final UserRepository userRepository;
    
    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
