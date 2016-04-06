package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Action")

public class Action {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Course.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "course_id")
    private Course course;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "startDate", nullable = false)
    private Date startDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "endDate", nullable = true)
    private Date endDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "lastChangeDate", nullable = false)
    private Date lastChangeDate;

    @Column(name = "evaluationType", nullable = false)
    private String evaluationType;

    @Column(name = "discount", nullable = false)
    private int discount;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "createdBy")
    private User createdBy;

    @Column(name = "visible", nullable = false)
    private boolean visible;

    @Column(name = "finalPrice", nullable = false)
    private int finalPrice;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "action",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModulePerAction> actionList = new HashSet<>();


    public int getId() { return id; }
    public Course getCourse() { return course; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public Date getCreationDate() { return creationDate; }
    public Date getLastChangeDate() { return lastChangeDate; }
    public int getDiscount() { return discount; }
    public boolean isVisible() { return visible; }
    public int getFinalPrice() { return finalPrice; }
    public User getCreatedBy() { return createdBy; }
    public String getEvaluationType() { return evaluationType; }
    public Set<ModulePerAction> getActionList() { return actionList; }

    public Action setCourse(Course course) { this.course = course; return this; }
    public Action setStartDate(Date startDate) { this.startDate = startDate; return this; }
    public Action setEndDate(Date endDate) { this.endDate = endDate; return this; }
    public Action setCreationDate(Date creationDate) { this.creationDate = creationDate; return this; }
    public Action setLastChangeDate(Date lastChangeDate) { this.lastChangeDate = lastChangeDate; return this; }
    public Action setVisible(boolean visible) { this.visible = visible; return this; }
    public Action setCreatedBy(User createdBy) { this.createdBy = createdBy; return this; }
    public Action setEvaluationType(String evaluationType) { this.evaluationType = evaluationType; return this; }

    public Action setDiscount(int discount) {
        this.finalPrice = this.course.getPrice() * (100-discount) / 100;
        this.discount = discount; return this;
    }



    @Override
    public String toString() {
        return "Action [id="            + this.id +
                ", Course="             + this.course +
                ", Date="               + this.startDate +
                ", visible="            + this.visible +
                ", Last Change Date="   + this.lastChangeDate +
                ", End Date="           + this.endDate +
                ", Last Change Date="   + this.lastChangeDate +
                ", Discount="           + this.discount +"]";
    }

    public Action changeVisibility() {
        if(this.visible) return this.setVisible(false);
        else return this.setVisible(true);

    }
}
