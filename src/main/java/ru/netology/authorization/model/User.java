package ru.netology.authorization.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @NotBlank
    @Size(min = 4, max = 20)
    private String pass;
    private boolean isAdmin;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
        this.isAdmin = false;
    }

    public User(String name, String pass, boolean isAdmin) {
        this.name = name;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }
}
