package com.notifier.mailNotifier.controller;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user-detail")
@SuppressWarnings("unchecked")
public class UserController {
    @Autowired
    private UserRequestHandler userRequestHandler;

    @Autowired
    private UserListHandler userListHandler;

    @Autowired
    private UserByIdHandler getUserById;

    @Autowired
    private UserUpdateHandler userUpdateHandler;

    @Autowired
    private UserRemoveHandler userRemoveHandler;

    @GetMapping("/home")
    public String getHome() {
        return "Home";
    }

    @PostMapping()
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequest userRequest) throws Exception {
        UserRequest user = userRequestHandler.doOperation(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<?> getList() throws Exception {
        List<UserRequest> userList = userListHandler.doOperation();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@Valid @PathVariable long id) throws Exception {
        UserRequest user = getUserById.doOperation(id);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @PathVariable long id, @RequestBody UserRequest userRequest) throws Exception {
        UserRequest updatedUser = userUpdateHandler.doOperation(id, userRequest);
        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@Valid @PathVariable long id) throws Exception {
        userRemoveHandler.doOperation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
