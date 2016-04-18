package com.weblink.core.models;


import javax.persistence.*;

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


    public int getId() { return id; }
    public User getUserA() { return userA; }
    public User getUserB() { return userB;}
    public boolean isAccepted() { return accepted; }

    public FriendRequest setUserA(User userA) { this.userA = userA; return this; }
    public FriendRequest setUserB(User userB) { this.userB = userB; return this; }
    public FriendRequest setAccepted(boolean accepted) { this.accepted = accepted; return this; }

    @Override
    public String toString() {
        return "FriendList [id="      + this.id             +
                ", a="                + this.userA          +
                ", b="                + this.userB          +
                ", state="            + this.isAccepted()   + "]";
    }

}
