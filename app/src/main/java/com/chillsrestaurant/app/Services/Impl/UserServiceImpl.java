package com.chillsrestaurant.app.services.impl;

import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.User;
import com.chillsrestaurant.app.repositories.UserRepository;
import com.chillsrestaurant.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> updateUser(Integer id, User updatedUser) {
        try {
            if (!this.userRepository.findById(id).isPresent()) {
                throw new Exception("User Not Found!");
            }
            updatedUser.setId(id);
            this.userRepository.saveAndFlush(updatedUser);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return this.getAllUsers();
    }

    @Override
    public List<User> deleteUser(Integer id) {
        try {
            if (!this.userRepository.findById(id).isPresent()) {
                throw new Exception("User Not Found!");
            }
            this.userRepository.deleteById(id);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return this.getAllUsers();
    }
}