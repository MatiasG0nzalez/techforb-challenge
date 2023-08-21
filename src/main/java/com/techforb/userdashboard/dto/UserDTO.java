package com.techforb.userdashboard.dto;

import com.techforb.userdashboard.model.Account;
import com.techforb.userdashboard.model.User;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    private long id;

    private String name;

    private String dni;

    private String password;


    private AccountDTO account;



    public UserDTO() {
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.dni = user.getDni();
        this.password = user.getPassword();
        this.account = new AccountDTO(user.getAccount());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }
}
