package com.notifier.mailNotifier.JWT;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserRequest userRequest = userRepo.findByUsername(s);

        if (userRequest == null)
            new UsernameNotFoundException("User not found");
        return new org.springframework.security.core.userdetails.User(userRequest.getUsername(), userRequest.getPassword(), getAuthority(userRequest));

    }
    private Set<SimpleGrantedAuthority> getAuthority(UserRequest userRequest) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userRequest.getRole()));
        return authorities;
    }

}
