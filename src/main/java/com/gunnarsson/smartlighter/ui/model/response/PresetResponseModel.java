package com.gunnarsson.smartlighter.ui.model.response;


public class PresetResponseModel {
    private String presetId;
    private LightResponseModel lightResponseModel;
    private boolean on;

    public LightResponseModel getLightResponseModel() {
        return lightResponseModel;
    }

    public void setLightResponseModel(LightResponseModel lightResponseModel) {
        this.lightResponseModel = lightResponseModel;
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
