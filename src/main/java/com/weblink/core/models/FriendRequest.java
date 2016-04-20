package com.weblink.core.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="FriendRequest")
public class FriendRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userA")
    private User userA;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userB")
    private User userB;

    @Column(name = "accepted", nullable = false)
    private boolean accepted;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "requestDate", nullable = false)
    private Date requestDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "acceptDate", nullable = true)
    private Date acceptDate;



    public int getId() { return id; }
    public User getUserA() { return userA; }
    public User getUserB() { return userB;}
    public boolean isAccepted() { return accepted; }
    public Date getRequestDate() { return requestDate; }
    public Date getAccepteDate() { return acceptDate; }

    public FriendRequest setUserA(User userA) { this.userA = userA; return this; }
    public FriendRequest setUserB(User userB) { this.userB = userB; return this; }
    public FriendRequest setAccepted(boolean accepted) { this.accepted = accepted; return this; }
    public FriendRequest setRequestDate(Date requestDate) { this.requestDate = requestDate; return this; }
    public FriendRequest setAccepteDate(Date accepteDate) { this.acceptDate = accepteDate; return this; }

    @Override
    public String toString() {
        return "FriendList [id="      + this.id             +
                ", a="                + this.userA          +
                ", b="                + this.userB          +
                ", state="            + this.isAccepted()   + "]";
    }

}
