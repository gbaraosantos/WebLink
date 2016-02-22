package com.weblink.core.models;

import javax.persistence.*;

@Entity
@Table(name="VerificationToken")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;


    public VerificationToken() {}
    public VerificationToken(String token, User user) {

        this.setToken(token);
        this.setUser(user);

    }

    public String getToken() {
        return token;
    }

    public VerificationToken setToken(String token) {
        this.token = token;
        return this;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public VerificationToken setId(int id) {
        this.id = id;
        return this;
    }

    public VerificationToken setUser(User user) {
        this.user = user;
        return this;
    }

}