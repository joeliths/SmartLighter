package com.gunnarsson.smartlighter.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "light")
public class LightEntity implements Serializable {
    private static final long serialVersionUID = 141231328765413026L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String lightId;

    @Column(nullable = false,length = 30)
    private String lightName;

    @Column(nullable = false)
    private String ipAddress;

    @ManyToOne
    @JoinColumn(name="site_id")
    private SiteEntity site;

    @OneToMany(mappedBy="light",cascade = CascadeType.ALL)
    private List<PresetEntity> presets;

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

    public SiteEntity getSite() {
        return site;
    }

    public void setSite(SiteEntity site) {
        this.site = site;
    }

    public List<PresetEntity> getPresets() { return presets; }

    public void setPresets(List<PresetEntity> presets) { this.presets = presets; }

}
