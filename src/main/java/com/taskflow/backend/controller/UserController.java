package com.taskflow.backend.controller;

import com.taskflow.backend.dto.user.CreateUserRequest;
import com.taskflow.backend.dto.user.UserResponse;
import com.taskflow.backend.entity.User;
import com.taskflow.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            UserResponse result = new UserResponse(user.get().getId()
                                                    , user.get().getUsername()
                                                    , user.get().getProfilePicturePath()
                                                    , user.get().getCreatedAt());
            return ResponseEntity.ok()
                    .body(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping
//    public ResponseEntity<CreateUserRequest> createUser(
//            @Valid @RequestBody CreateUserRequest request){
//
//       ResponseEntity response = userService.createUser(request);
//    }


}
