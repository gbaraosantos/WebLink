package com.weblink.core.models;


import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Users")
public class User{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=256)
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min=3, max=128)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(min=3, max=128)
    @Column(name = "password", nullable = false)
    private String password;

    @Size(min=3, max=256)
    @Column(name = "verificationToken")
    private String verificationToken;

    @DateTimeFormat(pattern="dd-MM-yyyy")
    @Column(name = "dateBirth", nullable = false)
    private Date dateBirth;

    @Size(min=3, max=64)
    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Size(min=3, max=256)
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "postal1", nullable = false)
    private Integer postal1;

    @Column(name = "postal2", nullable = false)
    private Integer postal2;

    @Column(name = "avatarLocation", nullable = false)
    private String avatarLocation;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm")
    @Column(name = "regDate", nullable = false)
    private Date regDate;

    @DateTimeFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @Column(name = "lastChangeDate", nullable = false)
    private Date lastChangeDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userFrom",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmailApp> sentList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userTo",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmailApp> receiveList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userA",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FriendRequest> friendRequestsA = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userB",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FriendRequest> friendRequestsB = new HashSet<>();


    @Column(name="state", nullable=false)
    private String state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserPermissions",
            joinColumns = { @JoinColumn(name = "UserID") },
            inverseJoinColumns = { @JoinColumn(name = "ProfileID") })
    private Set<UserProfile> userProfiles = new HashSet<>();


    /*Setters*/
    public User setName(String name) { this.name = name; return this; }
    public User setEmail(String email) { this.email = email; return this; }
    public User setPassword(String password) { this.password = password; return this; }
    public User setDateBirth(Date dateBirth) { this.dateBirth = dateBirth; return this; }
    public User setNationality(String nationality) { this.nationality = nationality; return this; }
    public User setAddress(String address) { this.address = address; return this; }
    public User setPostal1(Integer postal1) { this.postal1 = postal1; return this; }
    public User setPostal2(Integer postal2) { this.postal2 = postal2; return this; }
    public User setAvatarLocation(String avatarLocation) { this.avatarLocation = avatarLocation; return this; }
    public User setRegDate(Date regDate) { this.regDate = regDate; return this; }
    public User setLastChangeDate(Date lastChangeDate) { this.lastChangeDate = lastChangeDate; return this; }
    public User setState(String state) { this.state = state; return this; }
    public User setUserProfiles(Set<UserProfile> userProfiles) { this.userProfiles = userProfiles; return this; }
    public User setVerificationToken(String verificationToken) { this.verificationToken = verificationToken; return this; }

    /*Getters*/
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Date getDateBirth() { return dateBirth; }
    public String getNationality() { return nationality; }
    public String getAddress() { return address; }
    public Integer getPostal1() { return postal1; }
    public Integer getPostal2() { return postal2; }
    public String getAvatarLocation() { return avatarLocation; }
    public Date getRegDate() { return regDate; }
    public Date getLastChangeDate() { return lastChangeDate; }
    public Set<UserProfile> getUserProfiles() { return userProfiles; }
    public String getState() { return state; }
    public String getVerificationToken() { return verificationToken; }
    public Set<EmailApp> getSentList() { return sentList; }
    public Set<EmailApp> getReceiveList() { return receiveList; }
    public Set<FriendRequest> getFriendRequestsA() { return friendRequestsA; }
    public Set<FriendRequest> getFriendRequestsB() { return friendRequestsB; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof User)) return false;

        User other = (User) obj;
        if (this.id != other.getId()) return false;
        if (this.email == null) return false;
        if (this.email.equals(other.getEmail())) return true;

        return true;
    }

    public boolean hasPermission(String permissionType) {
        Set<UserProfile> a = getUserProfiles();

        for(UserProfile i : a){
            if(permissionType.equals(i.getType())) return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "User [id=" + this.id +
                ", email=" + this.email +
                ", password=" + this.password +
                ", name=" + this.email +
                ", state=" + this.state +
                ", userProfiles=" + userProfiles +"]";
    }
}

