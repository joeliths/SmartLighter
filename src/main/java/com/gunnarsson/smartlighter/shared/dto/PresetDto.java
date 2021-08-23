package com.gunnarsson.smartlighter.shared.dto;

import java.io.Serializable;

public class PresetDto implements Serializable {
    private static final long serialVersionUID = 912241238531312076L;
    private Long id;
    private String presetId;
    private LightDto light;
    private boolean on;
    private CollectionPresetDto collectionPreset;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public LightDto getLight() { return light; }

    public void setLight(LightDto light) {
        this.light = light;
    }

    public CollectionPresetDto getCollectionPreset() {
        return collectionPreset;
    }

    public void setCollectionPreset(CollectionPresetDto collectionPreset) {
        this.collectionPreset = collectionPreset;
    }

    public String getPresetId() {
        return presetId;
    }

    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }
}
