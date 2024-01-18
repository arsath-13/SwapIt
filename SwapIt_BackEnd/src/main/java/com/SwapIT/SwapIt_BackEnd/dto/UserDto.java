package com.SwapIT.SwapIt_BackEnd.dto;

import com.SwapIT.SwapIt_BackEnd.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
    private byte[] img;


}
