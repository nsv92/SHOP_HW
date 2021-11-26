package ru.gb.spring_shop_l2_1.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String password;

    private String firstName;

    private String lastName;

    private String email;

    public UserDto() {

    }
}
