package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name="StudentMPA")
public class StudentMPA {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "student")
    private Student student;

    @ManyToOne(targetEntity = ModulePerAction.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "modulePerAction")
    private ModulePerAction modulePerAction;

    @Column(name = "moduleGrade", nullable = false , columnDefinition = "int default 0")
    private int moduleGrade;

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public ModulePerAction getModulePerAction() { return modulePerAction; }
    public int getModuleGrade() { return moduleGrade; }

    public StudentMPA setStudent(Student student) { this.student = student; return this; }
    public StudentMPA setModulePerAction(ModulePerAction modulePerAction) { this.modulePerAction = modulePerAction; return this; }
    public StudentMPA setModuleGrade(int moduleGrade) { this.moduleGrade = moduleGrade; return this; }

    @Override
    public String toString() {
        return "StudentMPA [id="    + this.id               +
                ", moduleGrade="    + this.moduleGrade      +
                "\n"                + this.getStudent()     +
                "\n"                + this.getModulePerAction()      ;
    }
}
