package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(targetEntity = Action.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "action")
    private Action action;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "date", nullable = false)
    private Date buyDate;

    @Column(name = "price", nullable = false)
    private int buyPrice;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentMPA> studentMPAs = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostWall> postList = new HashSet<>();

    public int getId() { return id; }
    public User getUser() { return user; }
    public int getFinalGrade() {
        float finalGrade = 0;

        for(StudentMPA s: studentMPAs){
            finalGrade += s.getModuleGrade() * ((float)s.getModulePerAction().getModule().getPercentage() / 100);
        }

        return (int) Math.ceil((double) finalGrade);
    }

    public Action getAction() { return action; }
    public Date getBuyDate() { return buyDate; }

    public int getBuyPrice() { return buyPrice; }
    public Set<StudentMPA> getStudentMPAs() { return studentMPAs; }
    public Set<PostWall> getPostList() { return postList; }
    public Student setUser(User user) { this.user = user; return this; }
    public Student setFinalGrade(int finalGrade) { this.finalGrade = finalGrade; return this; }
    public Student setAction(Action action) { this.action = action; return this; }
    public Student setBuyDate(Date buyDate) { this.buyDate = buyDate; return this; }
    public Student setBuyPrice(int buyPrice) { this.buyPrice = buyPrice; return this; }

    @Override
    public String toString() {
        return "Student [id="       + this.id               +
                ", finalGrade="     + this.finalGrade       +
                "\n"                + this.getUser()
                ;
    }
}
