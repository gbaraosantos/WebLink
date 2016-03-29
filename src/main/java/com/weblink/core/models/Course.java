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
    @Column(name = "name", nullable = false, unique=true)
    private String name;

    @Size(min=6, max=2048)
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "reTryPrice", nullable = false)
    private int reTryPrice;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "createdBy")
    private User createdBy;

    @Size(min=3, max=256)
    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "nClasses", nullable = false)
    private int nClasses;

    @Column(name = "synch", nullable = false)
    private String synch;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "lastChangeDate", nullable = false)
    private Date lastChangeDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Column(name = "nModules", nullable = false)
    private int nModules;

    @Column(name = "tClass", nullable = false)
    private int tClass;


    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public String getArea() { return area; }
    public int getNumberClasses() { return nClasses; }
    public Date getLastChangeDate() { return lastChangeDate; }
    public Date getCreationDate() { return creationDate; }
    public int getNumberModules() { return nModules; }
    public String getSynch() { return synch; }
    public int getReTryPrice() { return reTryPrice; }
    public String getIcon() { return icon; }
    public int gettClass() { return tClass; }
    public User getCreatedBy() { return createdBy; }

    public Course setName(String name) { this.name = name; return this; }
    public Course setDescription(String description) { this.description = description; return this; }
    public Course setPrice(int price) { this.price = price; return this; }
    public Course setArea(String area) {this.area = area;return this;}
    public Course setNumberClasses(int numClasses) { this.nClasses = numClasses; return this; }
    public Course setSynch(String synch) { this.synch = synch; return this; }
    public Course setLastChangeDate(Date lastChangeDate) { this.lastChangeDate = lastChangeDate; return this; }
    public Course setCreationDate(Date creationDate) { this.creationDate = creationDate; return this; }
    public Course setNumberModules(int numberModules) { this.nModules = numberModules; return this; }
    public Course setReTryPrice(int reTryPrice) { this.reTryPrice = reTryPrice; return this; }
    public Course setIcon(String icon) { this.icon = icon; return this; }
    public Course settClass(int tClass) { this.tClass = tClass; return this; }
    public Course setCreatedBy(User createdBy) { this.createdBy = createdBy; return this; }

    @Override
    public String toString() {
        return "Course [id=" + this.id +
                ", name=" + this.name +
                ", price=" + this.price +
                ", area=" + this.area +
                ", synch=" + this.synch +
                ", icon=" + this.icon +"]";
    }
}
