package com.weblink.core.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="VerificationToken")
public class VerificationToken {
    private static final int Expiration = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private User user;

    private Date expiryDate;

    public VerificationToken() {}
    public VerificationToken(String token, User user) {

        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(Expiration);

    }

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }


    public static int getExpiration() {
        return Expiration;
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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public VerificationToken setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }
}