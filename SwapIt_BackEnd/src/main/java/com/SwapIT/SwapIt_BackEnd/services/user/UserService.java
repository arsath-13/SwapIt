package com.SwapIT.SwapIt_BackEnd.services.user;

import com.SwapIT.SwapIt_BackEnd.dto.SignupDto;
import com.SwapIT.SwapIt_BackEnd.dto.UserDto;

public interface UserService {
    UserDto createUser(SignupDto signupDto);

    boolean hasUserWithEmail(String email);
}
