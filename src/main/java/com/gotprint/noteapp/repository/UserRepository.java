package com.gotprint.noteapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gotprint.noteapp.entity.User;

/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username=:username")
    public Optional<User> findByUsername(@Param("username") String username);
}
