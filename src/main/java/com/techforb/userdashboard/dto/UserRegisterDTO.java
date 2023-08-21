package com.techforb.userdashboard.dto;

public class UserRegisterDTO {

    private String name;

    private String dni;

    private String password;

    public UserRegisterDTO(String name, String dni, String password) {
        this.name = name;
        this.dni = dni;
        this.password = password;
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
}
