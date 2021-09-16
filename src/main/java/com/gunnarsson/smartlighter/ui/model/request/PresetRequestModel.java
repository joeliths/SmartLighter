package com.gunnarsson.smartlighter.ui.model.request;

public class PresetRequestModel {
    private String presetId;
    private boolean lighted;

    public String getPresetId() {
        return presetId;
    }

    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }

    public boolean isLighted() {
        return lighted;
    }

    public void setLighted(boolean lighted) {
        this.lighted = lighted;
    }

}
