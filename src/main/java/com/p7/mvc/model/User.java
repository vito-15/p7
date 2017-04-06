package com.p7.mvc.model;

import org.springframework.stereotype.Component;

/**
 * Created by sadmin on 06.04.17.
 */
@Component
public class User {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
