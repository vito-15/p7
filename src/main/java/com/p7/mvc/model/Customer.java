package com.p7.mvc.model;

import org.springframework.stereotype.Component;

/**
 * Created by sadmin on 07.04.17.
 */
@Component
public class Customer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
