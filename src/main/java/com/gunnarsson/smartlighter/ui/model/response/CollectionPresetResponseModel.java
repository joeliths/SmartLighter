package com.gunnarsson.smartlighter.ui.model.response;

import java.util.List;

public class CollectionPresetResponseModel {
    private String collectionPresetId;
    private String collectionName;
    private List<PresetResponseModel> presets;

    public String getCollectionPresetId() {
        return collectionPresetId;
    }

    public void setCollectionPresetId(String collectionPresetId) {
        this.collectionPresetId = collectionPresetId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public List<PresetResponseModel> getPresets() {
        return presets;
    }

    public void setPresets(List<PresetResponseModel> presets) {
        this.presets = presets;
    }
}
