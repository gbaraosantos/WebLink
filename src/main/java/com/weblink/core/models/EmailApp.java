package com.weblink.core.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="EmailApp")
public class EmailApp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=256)
    @Column(name = "subject", nullable = false)
    private String subject;

    @Size(min=6, max=2048)
    @Column(name = "body", nullable = false)
    private String body;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userFrom")
    private User userFrom;

    @Column(name = "beenRead", nullable = false)
    private boolean beenRead;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userTo")
    private User userTo;

    @ManyToOne(targetEntity = Action.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "action")
    private Action action;

    public int getId() { return id; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public Action getAction() { return action; }
    public User getFrom() { return userFrom; }
    public User getTo() { return userTo; }
    public User getUserFrom() { return userFrom; }
    public boolean isBeenRead() { return beenRead; }
    public User getUserTo() { return userTo; }

    public EmailApp setSubject(String subject) { this.subject = subject; return this; }
    public EmailApp setBody(String body) { this.body = body; return this; }
    public EmailApp setAction(Action action) { this.action = action; return this; }
    public EmailApp setFrom(User from) { this.userFrom = from; return this; }
    public EmailApp setTo(User to) { this.userTo = to; return this; }
    public EmailApp setUserFrom(User userFrom) { this.userFrom = userFrom; return this; }
    public EmailApp setBeenRead(boolean beenRead) { this.beenRead = beenRead; return this; }
    public EmailApp setUserTo(User userTo) { this.userTo = userTo; return this; }

    @Override
    public String toString() {
        return "Mail [id="      + this.id           +
                ", subject="    + this.subject      +
                ", body="       + this.getBody()    +
                ", action="     + this.getAction()  +
                ", user="       + this.getFrom()    +
                ", icon="       + this.getTo()      + "]";
    }






}
