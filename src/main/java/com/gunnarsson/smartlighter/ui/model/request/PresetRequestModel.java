package com.gunnarsson.smartlighter.ui.model.request;

import com.gunnarsson.smartlighter.shared.dto.CollectionPresetDto;
import com.gunnarsson.smartlighter.shared.dto.LightDto;

public class PresetRequestModel {
    private String presetId;
    private LightDto light;
    private boolean on;

    public String getPresetId() {
        return presetId;
    }

    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }

    public LightDto getLight() {
        return light;
    }

    public void setLight(LightDto light) {
        this.light = light;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

}
