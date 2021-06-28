package com.gunnarsson.smartlighter.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="site")
public class SiteEntity implements Serializable {
    private static final long serialVersionUID = 7012313225526718056L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String siteId;

    @Column(nullable = false)
    private String siteName;

    @OneToMany(mappedBy="site")
    private List<LightEntity> lights;

    @OneToMany(mappedBy = "site")
    private List<UserEntity> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public List<LightEntity> getLights() {
        return lights;
    }

    public void setLights(List<LightEntity> lights) {
        this.lights = lights;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
