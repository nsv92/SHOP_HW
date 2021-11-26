package ru.gb.spring_shop_l2_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.spring_shop_l2_1.dto.UserDto;
import ru.gb.spring_shop_l2_1.entity.Role;
import ru.gb.spring_shop_l2_1.entity.User;
import ru.gb.spring_shop_l2_1.repository.RoleRepository;
import ru.gb.spring_shop_l2_1.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> maybeUser = userRepository.findByUserName(userName);
        if (maybeUser.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username/password!");
        }
        User user = maybeUser.get();
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority>
    mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new
                SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public User registerNewUser(UserDto userDto) throws Exception {
        if (usernameExists(userDto.getUserName())) {
            throw new Exception("User with " + userDto.getUserName() + " is already exist!");
        }
        User user = new User();
        user.setUserName(userDto.getUserName());
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encryptedPassword);
        Collection<Role> roles = new ArrayList<Role>();
        Optional<Role> customerRole = roleRepository.findById(2L);
        roles.add(customerRole.get());
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.findByUserName(username).isPresent();
    }
}
