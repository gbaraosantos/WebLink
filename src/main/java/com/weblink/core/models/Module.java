package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Module")
public class Module {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=256)
    @Column(name = "name", nullable = false, unique=true)
    private String name;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "createdBy")
    private User createdBy;

    @ManyToOne(targetEntity = Course.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "course_id")
    private Course course;

    @Size(min=6, max=2048)
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "percentage", nullable = false)
    private int percentage;

    @Column(name = "position", nullable = false)
    private int position;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "lastChangeDate", nullable = false)
    private Date lastChangeDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "module",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModulePerAction> moduleList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "module",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Material> materialList = new HashSet<>();


    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPercentage() { return percentage; }
    public int getPosition() { return position; }
    public Date getLastChangeDate() { return lastChangeDate; }
    public Date getCreationDate() { return creationDate; }
    public User getCreatedBy() { return createdBy; }
    public Course getCourse() { return course; }
    public Set<ModulePerAction> getModuleList() { return moduleList; }
    public Set<Material> getMaterialList() { return materialList; }

    public Module setName(String name) { this.name = name; return this; }
    public Module setDescription(String description) { this.description = description; return this; }
    public Module setPercentage(int percentage) { this.percentage = percentage; return this; }
    public Module setPosition(int position) { this.position = position; return this; }
    public Module setLastChangeDate(Date lastChangeDate) { this.lastChangeDate = lastChangeDate; return this; }
    public Module setCreationDate(Date creationDate) { this.creationDate = creationDate; return this; }
    public Module setCreatedBy(User createdBy) { this.createdBy = createdBy; return this; }
    public Module setCourse(Course course) { this.course = course; return this; }

    @Override
    public String toString() {
        return "Module [id="        + this.id               +
                ", name="           + this.name             +
                ", createdBy="      + this.createdBy        +
                ", creationDate="   + this.creationDate     +
                ", position="       + this.position +"]";
    }

}
