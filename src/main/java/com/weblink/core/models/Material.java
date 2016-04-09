package com.weblink.core.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Material")
public class Material {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=256)
    @Column(name = "name", nullable = false, unique=true)
    private String name;

    @Size(min=6, max=2048)
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "size", nullable = false)
    private int size;

    @ManyToOne(targetEntity = Module.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "module")
    private Module module;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "uploadedBy")
    private User uploadedBy;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @Size(min=3, max=256)
    @Column(name = "extension", nullable = false)
    private String extension;

    @Size(min=3, max=256)
    @Column(name = "fileType", nullable = false)
    private String fileType;

    @Size(min=6, max=2048)
    @Column(name = "directory", nullable = false)
    private String directory;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public User getUploadedBy() { return uploadedBy; }
    public Date getCreationDate() { return creationDate; }
    public String getExtension() { return extension; }
    public String getFileType() { return fileType; }
    public String getDirectory() { return directory; }
    public Module getModule() { return module; }
    public int getSize() { return size; }

    public Material setName(String name) { this.name = name; return this; }
    public Material setDescription(String description) { this.description = description; return this; }
    public Material setSize(int size) { this.size = size; return this; }
    public Material setModule(Module module) { this.module = module; return this; }
    public Material setUploadedBy(User uploadedBy) { this.uploadedBy = uploadedBy; return this; }
    public Material setCreationDate(Date creationDate) { this.creationDate = creationDate; return this; }
    public Material setExtension(String extension) { this.extension = extension; return this; }
    public Material setFileType(String fileType) { this.fileType = fileType; return this; }
    public Material setDirectory(String directory) { this.directory = directory; return this; }

    @Override
    public String toString() {
        return "Material [id="      + this.id +
                ", name="           + this.name +
                ", Description="    + this.description +
                ", size="           + this.size + "MBytes" +
                ", FileType="       + this.fileType +
                ", directory="      + this.directory +"]";
    }



}
