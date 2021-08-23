package com.gunnarsson.smartlighter.shared.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class LightDto implements Serializable {
    private static final long serialVersionUID = 843241328566413086L;
    private Long id;
    private String lightId;
    private String lightName;
    private String ipAddress;
    private SiteDto siteDto;
    private List<PresetDto> presets;

    public Long getId() { return id; }

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

    public SiteDto getSiteDto() {
        return siteDto;
    }

    public void setSiteDto(SiteDto siteDto) {
        this.siteDto = siteDto;
    }

    public List<PresetDto> getPresets() {
        return presets;
    }

    public void setPresets(List<PresetDto> presets) {
        this.presets = presets;
    }
}
