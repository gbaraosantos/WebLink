package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CertificateRequest")
public class CertificateRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Action.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "action")
    private Action action;

    @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "student")
    private Student student;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    public int getId() { return id; }
    public Action getAction() { return action; }
    public Student getStudent() { return student; }
    public Date getCreationDate() { return creationDate; }

    public CertificateRequest setAction(Action action) { this.action = action; return this; }
    public CertificateRequest setStudent(Student student) { this.student = student; return this; }
    public CertificateRequest setCreationDate(Date creationDate) { this.creationDate = creationDate; return this; }

    @Override
    public String toString() {
        return "CertificateRequest [id="        + this.id               +
                "\n"                            + this.action       +
                "\n"                            + this.student
                ;
    }


}
