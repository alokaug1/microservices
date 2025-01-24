package com.example.userservice.service;

import com.example.userservice.model.Users;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
    	Optional<Users> users = userRepository.findById(id);
    	System.out.println("Users:::"+users.get());
    	return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
