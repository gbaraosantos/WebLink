package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PostWall")
public class PostWall {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "creationDate", nullable = true)
    private Date creationDate;

    @ManyToOne(targetEntity = Action.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "action")
    private Action action;


    @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "student")
    private Student student;


    public int getId() { return id; }
    public Date getCreationDate() { return creationDate; }
    public Action getAction() { return action; }
    public Student getStudent() { return student; }

    public PostWall setCreationDate(Date creationDate) { this.creationDate = creationDate; return this; }
    public PostWall setAction(Action action) { this.action = action; return this; }
    public PostWall setStudent(Student student) { this.student = student; return this; }

    @Override
    public String toString() {
        return "Post Wall [id="     + this.id               +
                ", creationDate="   + this.creationDate     +
                "\n"                + this.getStudent()     +
                "\n"                + this.getAction()      ;
    }


}
