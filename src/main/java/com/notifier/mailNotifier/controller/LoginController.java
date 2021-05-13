package com.notifier.mailNotifier.controller;


import com.notifier.mailNotifier.JWT.JwtUtil;
import com.notifier.mailNotifier.JWT.MyUserDetailService;
import com.notifier.mailNotifier.JWT.TokenProvider;
import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.handler.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.notifier.mailNotifier.util.Constants.TOKEN_PREFIX;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRequestHandler userRequestHandler;

    @PostMapping("/sign-in")
    public ResponseEntity<?> createToken(@RequestBody UserRequest userRequest) throws Exception {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userRequest.getUsername(),
                            userRequest.getPassword()
                    )
            );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String jwt = TOKEN_PREFIX + jwtUtil.generateToken(authentication);
        return ResponseEntity.ok(new TokenProvider(jwt));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequest userRequest) throws Exception {
        UserRequest user = userRequestHandler.doOperation(userRequest);
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


}
