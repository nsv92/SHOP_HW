package ru.gb.spring_shop_l2_1.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.gb.spring_shop_l2_1.dto.UserDto;
import ru.gb.spring_shop_l2_1.entity.User;

public interface UserService extends UserDetailsService {

    User registerNewUser(UserDto userDto) throws Exception;

    boolean usernameExists (String username);
}
