package com.notifier.mailNotifier.JWT;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserRequest userRequest = userRepo.findByUsername(s);
        if (userRequest == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(userRequest.getUsername(),userRequest.getPassword(), new ArrayList<>());
    }
}
