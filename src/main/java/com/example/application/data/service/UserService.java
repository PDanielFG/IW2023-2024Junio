package com.example.application.data.service;

import com.example.application.data.entity.User;
import com.example.application.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public long count() {
        return userRepository.count();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void save(User user) {
        if (user == null) {
            System.err.println("User is null");
            return;
        }
        userRepository.save(user);
    }

    public User findByID(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}