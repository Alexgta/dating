package com.job4j.dating.service;

import com.job4j.dating.controller.dto.UserRegistrationDto;
import com.job4j.dating.dao.WebUserRepository;
import com.job4j.dating.entity.WebUser;
import com.job4j.dating.entity.dict.WebRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    private WebUserRepository theWebUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public WebUser findByEmail(String email){
        return theWebUserRepository.findByEmail(email);
    }

    public WebUser save(UserRegistrationDto registration){
        WebUser user = new WebUser();
        user.setName(registration.getName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setCurRole(registration.getCurRole());
        //user.setRoles(Arrays.asList(new WebRole("WEB")));
        user.setRoles(new ArrayList<>());
        return theWebUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        WebUser user = theWebUserRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<WebRole> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
