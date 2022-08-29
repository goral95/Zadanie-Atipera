package com.lukaszgorczyk.rekrutacja.model;

import java.util.List;

public class UserRepository {
    private String name;
    private String login;
    private Branch[] branches;

    public UserRepository(String name, String login, Branch[] branches) {
        this.name = name;
        this.login = login;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Branch[] getBranches() {
        return branches;
    }

    public void setBranches(Branch[] branches) {
        this.branches = branches;
    }
}
