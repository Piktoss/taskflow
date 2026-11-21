package com.taskflow.backend.service;

import com.taskflow.backend.user.UserRepository;
import com.taskflow.backend.user.UserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

//    @Test
//    void shouldReturnTrueWhenEmailExists(){
//        String email = "alice@test.com";
//        User mockUser = mock(User.class);
//        when(userRepository.findByEmail(email))
//                .thenReturn(Optional.of(mockUser));
//
//        //act
//        boolean result = userService.isEmailTaken(email);
//
//        //Assert
//        assertTrue(result);
//
//    }


//    @Test
//    void shouldReturnFalseWhenEmailDoesNotExist(){
//        //arrange
//        String email = "alice@test.com";
//        when(userRepository.findByEmail(email))
//                .thenReturn(Optional.empty());
//        //act
//        boolean result = userService.isEmailTaken(email);
//
//        //assert
//        assertFalse(result);
//    }



}
