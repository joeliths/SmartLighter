package com.gunnarsson.smartlighter.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 5012315223526710046L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false,length = 20)
    private String firstName;

    @Column(nullable = false,length = 60)
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;

    @ManyToOne
    @JoinColumn(name="site_id")
    private SiteEntity site;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public SiteEntity getSite() {
        return site;
    }

    public void setSite(SiteEntity site) {
        this.site = site;
    }

}
