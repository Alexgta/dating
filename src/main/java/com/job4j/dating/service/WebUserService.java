package com.job4j.dating.service;

import com.job4j.dating.entity.WebUser;
import com.job4j.dating.controller.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface WebUserService extends UserDetailsService {

    WebUser findByEmail(String email);

    WebUser save(UserRegistrationDto registration);

}
