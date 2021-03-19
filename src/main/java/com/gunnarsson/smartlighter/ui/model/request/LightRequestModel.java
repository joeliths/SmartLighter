package com.gunnarsson.smartlighter.ui.model.request;

public class LightRequestModel {
    private String lightName;
    private String ipAddress;

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
