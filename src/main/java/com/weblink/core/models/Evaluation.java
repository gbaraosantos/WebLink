package com.weblink.core.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluation",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questionList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evaluation",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentPerEvaluation> SPEList = new HashSet<>();

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "dueDate", nullable = false)
    private Date dueDate;

    @Column(name = "evaluated", nullable = false)
    private boolean evaluated;

    @Column(name = "classs", nullable = false)
    private boolean classs;

    @ManyToOne(targetEntity = ModulePerAction.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "modulePerAction")
    private ModulePerAction modulePerAction;

    public ModulePerAction getModulePerAction() {
        return modulePerAction;
    }

    public Evaluation setModulePerAction(ModulePerAction modulePerAction) {
        this.modulePerAction = modulePerAction;
        return this;
    }

    public Set<StudentPerEvaluation> getSPEList() {
        return SPEList;
    }

    public boolean isClasss() {
        return classs;
    }

    public Evaluation setClasss(boolean classs) {
        this.classs = classs;
        return this;
    }

    public int getId() {
        return id;
    }

    public Set<Question> getQuestionList() {
        return questionList;
    }

    public Evaluation setQuestionList(Set<Question> questionList) {
        this.questionList = questionList;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Evaluation setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Evaluation setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public Evaluation setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
        return this;
    }



    @Override
    public String toString() {
        return "Material [id="      + this.id +
                ", dueDate="           + this.dueDate +
                ", creationDate="    + this.creationDate +"]";
    }
}
