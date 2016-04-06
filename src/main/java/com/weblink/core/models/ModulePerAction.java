package com.weblink.core.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ModulePerAction")
public class ModulePerAction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "startDate", nullable = true)
    private Date startDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "endDate", nullable = true)
    private Date endDate;

    @ManyToOne(targetEntity = Module.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "module")
    private Module module;

    @ManyToOne(targetEntity = Action.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "action")
    private Action action;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "modulePerAction",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Teacher> teacherList = new HashSet<>();

    public int getId() { return id; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public Module getModule() { return module; }
    public Action getAction() { return action; }
    public Set<Teacher> getTeacherList() { return teacherList; }

    public ModulePerAction setStartDate(Date startDate) { this.startDate = startDate; return this; }
    public ModulePerAction setEndDate(Date endDate) { this.endDate = endDate; return this; }
    public ModulePerAction setModule(Module module) { this.module = module; return this; }
    public ModulePerAction setAction(Action action) { this.action = action; return this; }
    public ModulePerAction setTeacherList(Set<Teacher> teacherList) { this.teacherList = teacherList; return this; }

    @Override
    public String toString() {
        return "ModulePerAction [id="        + this.id               +
                ", startDate="      + this.startDate        +
                ", endDate="        + this.endDate          +
                "\n"                + this.getModule()      +
                "\n"                + this.getAction()      ;
    }


}
