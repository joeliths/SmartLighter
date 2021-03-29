package com.gunnarsson.smartlighter.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity(name = "lights")
public class LightEntity implements Serializable {
    private static final long serialVersionUID = 141231328765413026L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String lightId;

    @Column(nullable = false)
    private String lightName;

    @Column(nullable = false)
    private String ipAddress;

    @ManyToOne
    @JoinColumn(name="site_id")
    private SiteEntity site;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLightId() {
        return lightId;
    }

    public void setLightId(String lightId) {
        this.lightId = lightId;
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
