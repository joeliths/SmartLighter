package com.gunnarsson.smartlighter.io.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="sites")
public class SiteEntity implements Serializable {
    private static final long serialVersionUID = 7012313225526718056L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String siteId;

    @Column(nullable = false)
    private String siteName;

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
}
