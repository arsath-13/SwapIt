package com.SwapIT.SwapIt_BackEnd.services.user;

import com.SwapIT.SwapIt_BackEnd.dto.SignupDto;
import com.SwapIT.SwapIt_BackEnd.dto.UserDto;
import com.SwapIT.SwapIt_BackEnd.entities.User;
import com.SwapIT.SwapIt_BackEnd.enums.UserRole;
import com.SwapIT.SwapIt_BackEnd.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
        if(adminAccount == null) {
            User user = new User();
            user.setUserRole(UserRole.ADMIN);
            user.setEmail("swapitjpura@gmail.com");
            user.setName("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("@Admin13"));
            userRepository.save(user);
        }
    }

    @Override
    public UserDto createUser(SignupDto signupDto) {
        User user = new User();
        user.setName(signupDto.getName());
        user.setEmail(signupDto.getEmail());
        user.setUserRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(signupDto.getPassword()));
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        userDto.setName(createdUser.getName());
        userDto.setEmail(createdUser.getEmail());
        userDto.setUserRole(createdUser.getUserRole());
        return userDto;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email)!=null;
    }
}
