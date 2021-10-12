package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity()
@Table(name = "burger_user")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    private boolean premiumMember;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }
}
