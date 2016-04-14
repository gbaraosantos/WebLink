package com.weblink.core.models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Platform")
public class Platform {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=256)
    @Column(name = "globalChatSession", nullable = false, unique=true)
    private String globalChatSession;

    public String getGlobalChatSession() { return globalChatSession; }
    public int getId() { return id; }

    public Platform setGlobalChatSession(String globalChatSession) { this.globalChatSession = globalChatSession; return this; }
}
