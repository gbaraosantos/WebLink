package com.weblink.core.models;

import javax.persistence.*;

@Entity
@Table(name="Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, name = "teacher")
    private User teacher;

    @ManyToOne(targetEntity = ModulePerAction.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "modulePerAction")
    private ModulePerAction modulePerAction;


    public int getId() { return id; }
    public User getTeacher() { return teacher; }
    public ModulePerAction getModulePerAction() { return modulePerAction; }

    public Teacher setTeacher(User teacher) { this.teacher = teacher; return this; }
    public Teacher setModulePerAction(ModulePerAction modulePerAction) { this.modulePerAction = modulePerAction; return this; }

    @Override
    public String toString() {
        return "teacher [id="       + this.id               +
                "\n"                + this.getTeacher()     +
                "\n"                + this.getModulePerAction()
                ;
    }

}
