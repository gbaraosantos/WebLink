package com.weblink.core.models;

import javax.persistence.*;

@Entity
@Table(name="StudentPerEvaluation")
public class StudentPerEvaluation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = StudentMPA.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "studentMPA")
    private StudentMPA studentMPA;

    @ManyToOne(targetEntity = Evaluation.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "evaluation")
    private Evaluation evaluation;

    @Column(name = "grade", nullable = false, columnDefinition = "int default 0")
    private int grade;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    public int getGrade() {
        return grade;
    }

    public StudentPerEvaluation setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public boolean isCompleted() {
        return completed;
    }

    public StudentPerEvaluation setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }

    public int getId() {
        return id;
    }

    public StudentMPA getStudentMPA() {
        return studentMPA;
    }

    public StudentPerEvaluation setStudentMPA(StudentMPA studentMPA) {
        this.studentMPA = studentMPA;
        return this;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public StudentPerEvaluation setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
        return this;
    }
}
