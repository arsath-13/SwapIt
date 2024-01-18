package com.SwapIT.SwapIt_BackEnd.entities;

import com.SwapIT.SwapIt_BackEnd.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import com.SwapIT.SwapIt_BackEnd.enums.UserRole;

@Entity
@Data
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
    private byte[] img;

    public UserDto mapUserToUserDto() {
        return new UserDto(id,email,name,userRole);
    }


}
