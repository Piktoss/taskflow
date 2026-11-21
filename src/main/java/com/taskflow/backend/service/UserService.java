package com.taskflow.backend.service;
import com.taskflow.backend.dto.user.CreateUserRequest;
import com.taskflow.backend.entity.User;
import com.taskflow.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
//    public User createUser(CreateUserRequest user){
//        return userRepository.save(user);
//    }


}
