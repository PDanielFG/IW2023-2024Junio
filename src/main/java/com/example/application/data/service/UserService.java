package com.example.application.data.service;

import com.example.application.data.entity.User;
import com.example.application.data.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import org.slf4j.Logger;


@Service
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    public void registerUser(String username, String name, String email, String password) {
        // Verificar si el usuario ya existe en la base de datos
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        // Crear una nueva instancia de usuario y establecer los datos
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setName(name);
        newUser.setEmail(email);

        // Codificar la contraseña antes de guardarla en la base de datos
        String encodedPassword = passwordEncoder.encode(password);
        newUser.setHashedPassword(encodedPassword);

        // Guardar el nuevo usuario en la base de datos
        userRepository.save(newUser);
    }

}