package com.gunnarsson.smartlighter.ui.model.request;

public class LightStateModel {
    private String lightId;
    private boolean on;

    public String getLightId() {
        return lightId;
    }

    public void setLightId(String lightId) {
        this.lightId = lightId;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
