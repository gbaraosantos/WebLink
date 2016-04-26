package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "sentDate", nullable = false)
    private Date sentDate;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userTo")
    private User userTo;


    public int getId() { return id; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public User getFrom() { return userFrom; }
    public User getTo() { return userTo; }
    public User getUserFrom() { return userFrom; }
    public boolean isBeenRead() { return beenRead; }
    public User getUserTo() { return userTo; }
    public Date getSentDate() { return sentDate; }

    public EmailApp setSubject(String subject) { this.subject = subject; return this; }
    public EmailApp setBody(String body) { this.body = body; return this; }
    public EmailApp setFrom(User from) { this.userFrom = from; return this; }
    public EmailApp setTo(User to) { this.userTo = to; return this; }
    public EmailApp setBeenRead(boolean beenRead) { this.beenRead = beenRead; return this; }
    public EmailApp setSentDate(Date sentDate) { this.sentDate = sentDate; return this; }


    @Override
    public String toString() {
        return "Mail [id="      + this.id           +
                ", subject="    + this.subject      +
                ", body="       + this.getBody()    +
                ", user="       + this.getFrom()    +
                ", icon="       + this.getTo()      + "]";
    }






}
