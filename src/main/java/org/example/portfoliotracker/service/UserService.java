package org.example.portfoliotracker.service;

import org.example.portfoliotracker.model.User;
import org.example.portfoliotracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User getUserById(Long id) { return userRepository.findById(id);}

    public void createUser(User user) { userRepository.create(user); }

    public void updateUser(User user) { userRepository.update(user); }

    public void deleteUser(Long id) { userRepository.deleteById(id); }
}
