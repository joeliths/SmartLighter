package com.gunnarsson.smartlighter.ui.model.response;


public class PresetResponseModel {
    private String presetId;
    private LightResponseModel light;
    private boolean on;

    public LightResponseModel getLight() {
        return light;
    }

    public void setLight(LightResponseModel light) {
        this.light = light;
    }

    public String getPresetId() {
        return presetId;
    }

    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
