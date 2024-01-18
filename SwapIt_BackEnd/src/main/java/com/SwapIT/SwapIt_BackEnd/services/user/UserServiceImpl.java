package com.SwapIT.SwapIt_BackEnd.services.user;

import com.SwapIT.SwapIt_BackEnd.dto.SignupDto;
import com.SwapIT.SwapIt_BackEnd.dto.UserDto;
import com.SwapIT.SwapIt_BackEnd.entities.User;
import com.SwapIT.SwapIt_BackEnd.enums.UserRole;
import com.SwapIT.SwapIt_BackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(SignupDto signupDto) {
        User user = new User();
        user.setName(signupDto.getName());
        user.setEmail(signupDto.getEmail());
        user.setUserRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(signupDto.getPassword()));
        userRepository.save(user);
        return user.mapUserToUserDto();
    }
}
