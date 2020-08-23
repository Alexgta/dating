package com.job4j.dating.service;

import com.job4j.dating.controller.dto.UserRegistrationDto;
import com.job4j.dating.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

}