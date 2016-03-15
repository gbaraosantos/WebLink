package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=256)
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(min=6, max=2048)
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Size(min=3, max=256)
    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "numClasses", nullable = false)
    private int numClasses;

    @Column(name = "synch", nullable = false)
    private boolean synch;

    @Column(name = "visible", nullable = false)
    private boolean visible;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "lastChangeDate", nullable = false)
    private Date lastChangeDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Column(name = "numberModules", nullable = false)
    private int numberModules;


    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public String getArea() { return area; }
    public int getNumClasses() { return numClasses; }
    public boolean isSynch() { return synch; }
    public Date getLastChangeDate() { return lastChangeDate; }
    public Date getCreationDate() { return creationDate; }
    public int getNumberModules() { return numberModules; }
    public boolean isVisible() { return visible; }


    public Course setName(String name) { this.name = name; return this; }
    public Course setDescription(String description) { this.description = description; return this; }
    public Course setPrice(int price) { this.price = price; return this; }
    public Course setArea(String area) { this.area = area; return this; }
    public Course setNumClasses(int numClasses) { this.numClasses = numClasses; return this; }
    public Course setSynch(boolean synch) { this.synch = synch; return this; }
    public Course setLastChangeDate(Date lastChangeDate) { this.lastChangeDate = lastChangeDate; return this; }
    public Course setCreationDate(Date creationDate) { this.creationDate = creationDate; return this; }
    public Course setNumberModules(int numberModules) { this.numberModules = numberModules; return this; }
    public Course setVisible(boolean visible) { this.visible = visible; return this; }
}
