package com.gotprint.noteapp.security;

import java.util.Optional;

import com.gotprint.noteapp.entity.User;

/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
