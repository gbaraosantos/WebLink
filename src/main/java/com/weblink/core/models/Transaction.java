package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "student")
    private Student student;

    @ManyToOne(targetEntity = Action.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "action")
    private Action action;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "price", nullable = false)
    private int price;

    public int getId() { return id; }
    public Date getDate() { return date; }
    public int getPrice() { return price; }
    public Student getStudent() { return student; }
    public Action getAction() { return action; }

    public Transaction setDate(Date date) { this.date = date; return this; }
    public Transaction setPrice(int price) { this.price = price; return this; }
    public Transaction setStudent(Student student) { this.student = student; return this; }
    public Transaction setAction(Action action) { this.action = action; return this; }

    @Override
    public String toString() {
        return "Transaction [id="   + this.id               +
                ", date="           + this.date             +
                ", price="          + this.price            +
                "\n"                + this.getStudent()     ;
    }
}
