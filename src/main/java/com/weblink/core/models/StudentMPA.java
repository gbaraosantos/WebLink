package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="StudentMPA")
public class StudentMPA {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "student")
    private Student student;

    @ManyToOne(targetEntity = ModulePerAction.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "modulePerAction")
    private ModulePerAction modulePerAction;

    @Column(name = "moduleGrade", nullable = false , columnDefinition = "int default 0")
    private int moduleGrade;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "studentMPA",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentPerEvaluation> evalList = new HashSet<>();

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public ModulePerAction getModulePerAction() { return modulePerAction; }
    public int getModuleGrade() {
        float finalGrade = 0;
        int count = 0;

        if(evalList.size() ==0) return 0;

        System.out.println("got here");
        for(StudentPerEvaluation s: evalList){

            if(s.getEvaluation().isEvaluated())
                count++;
                finalGrade += s.getGrade();
        }

        return (int) Math.ceil((double) finalGrade / count);
    }

    public StudentMPA setStudent(Student student) { this.student = student; return this; }
    public StudentMPA setModulePerAction(ModulePerAction modulePerAction) { this.modulePerAction = modulePerAction; return this; }
    public StudentMPA setModuleGrade(int moduleGrade) { this.moduleGrade = moduleGrade; return this; }

    public Set<StudentPerEvaluation> getEvalList() {return evalList;}

    @Override
    public String toString() {
        return "StudentMPA [id="    + this.id               +
                ", moduleGrade="    + this.moduleGrade      +
                "\n"                + this.getStudent()     +
                "\n"                + this.getModulePerAction()      ;
    }
}
