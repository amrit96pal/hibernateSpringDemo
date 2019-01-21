package com.stackroute.model;

import javax.persistence.*;

@Entity
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @Column
    private String username;
    @Column
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
