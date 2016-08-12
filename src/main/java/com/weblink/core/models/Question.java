package com.weblink.core.models;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name="Question")
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Evaluation.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "evaluation")
    private Evaluation evaluation;

    @Size(min=3, max=256)
    @Column(name = "Question", nullable = false, unique=true)
    private String question;

    @Size(min=3, max=256)
    @Column(name = "a", nullable = false, unique=true)
    private String a;

    @Size(min=3, max=256)
    @Column(name = "b", nullable = false, unique=true)
    private String b;

    @Size(min=3, max=256)
    @Column(name = "c", nullable = false, unique=true)
    private String c;

    @Size(min=3, max=256)
    @Column(name = "d", nullable = false, unique=true)
    private String d;


    public Evaluation getEvaluation() {
        return evaluation;
    }

    public Question setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getA() {
        return a;
    }

    public Question setA(String a) {
        this.a = a;
        return this;
    }

    public String getB() {
        return b;
    }

    public Question setB(String b) {
        this.b = b;
        return this;
    }

    public String getC() {
        return c;
    }

    public Question setC(String c) {
        this.c = c;
        return this;
    }

    public String getD() {
        return d;
    }

    public Question setD(String d) {
        this.d = d;
        return this;
    }

    public int getId() {
        return id;
    }

    public List<String> getShuffled(){
        List <String> e = new LinkedList<>();

        e.add(this.a);
        e.add(this.b);
        e.add(this.c);
        e.add(this.d);

        Collections.shuffle(e, new Random());
        return e;


    }
}
