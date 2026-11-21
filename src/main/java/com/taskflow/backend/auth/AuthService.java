package com.taskflow.backend.auth;

import com.taskflow.backend.auth.dto.RegisterRequest;
import com.taskflow.backend.user.dto.UserResponse;
import com.taskflow.backend.exception.EmailNotAvailable;
import com.taskflow.backend.exception.UsernameNotAvailable;
import com.taskflow.backend.user.User;
import com.taskflow.backend.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean isUsernameTaken(String username){
        return userRepository.findByUsername(username).isPresent();
    }

    public UserResponse createUser(RegisterRequest request) throws EmailNotAvailable, UsernameNotAvailable {
        if (isEmailTaken(request.email())){
            throw new EmailNotAvailable("Email is already taken");
        }
        if(isUsernameTaken(request.username())){
            throw new UsernameNotAvailable("Username is taken");
        }
        String hashedPassword = passwordEncoder.encode(request.password());

        User user = new User(
                request.username(),
                request.email(),
                hashedPassword,
                request.profilePicture());

        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getProfilePicturePath(),
                savedUser.getCreatedAt()
                );
    }
}
