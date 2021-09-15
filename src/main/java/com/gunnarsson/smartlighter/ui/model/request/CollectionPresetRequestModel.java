package com.gunnarsson.smartlighter.ui.model.request;

import java.util.List;
import java.util.Set;

public class CollectionPresetRequestModel {
    private String collectionName;
    private List<LightStateModel> presets;

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public List<LightStateModel> getPresets() {
        return presets;
    }

    public void setPresets(List<LightStateModel> presets) {
        this.presets = presets;
    }

}
