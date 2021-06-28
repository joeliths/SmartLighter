package com.gunnarsson.smartlighter.shared.dto;

import java.io.Serializable;
import java.util.List;

public class CollectionPresetDto implements Serializable {
    private static final long serialVersionUID = 242241228511313086L;
    private Long id;
    private String collectionPresetId;
    private String collectionName;
    private List<PresetDto> presets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<PresetDto> getPresets() {
        return presets;
    }

    public void setPresets(List<PresetDto> presets) {
        this.presets = presets;
    }

}
