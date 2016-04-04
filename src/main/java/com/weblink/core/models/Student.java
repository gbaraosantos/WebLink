package com.weblink.core.models;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user")
    private User user;

    @Column(name = "finalGrade", nullable = false, columnDefinition = "int default 0")
    private int finalGrade;

    public int getId() { return id; }
    public User getUser() { return user; }
    public int getFinalGrade() { return finalGrade; }

    public Student setUser(User user) { this.user = user; return this; }
    public Student setFinalGrade(int finalGrade) { this.finalGrade = finalGrade; return this; }

    @Override
    public String toString() {
        return "Student [id="       + this.id               +
                ", finalGrade="     + this.finalGrade       +
                "\n"                + this.getUser()
                ;
    }
}
