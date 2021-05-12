package com.notifier.mailNotifier.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "UserRequest")
public class UserRequest {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Username cannot be null")
    private String username;

    private String fullName;

    @NotBlank(message = "password should not be null")
    private String password;

    private String role;
    private Integer phoneNo;

    public UserRequest() { }

    public UserRequest(long id, @Pattern(regexp = "^(.+)@(.+)$", message = "Username cannot be null")
            String username, String fullName,
                       @NotBlank(message = "password should not be null") String password, String role, Integer phoneNo) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.phoneNo = phoneNo;
    }

    public UserRequest(String username,  String password) {
        this.username = username;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }
}
