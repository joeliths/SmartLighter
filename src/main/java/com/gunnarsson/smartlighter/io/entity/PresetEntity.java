package com.gunnarsson.smartlighter.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="preset")
public class PresetEntity implements Serializable {
    private static final long serialVersionUID = 1113121765113426L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String presetId;

    @ManyToOne
    @JoinColumn(name = "light_id")
    private LightEntity light;

    @ManyToOne
    @JoinColumn(name="collection_id")
    private CollectionPresetEntity collectionPreset;

    @Column
    private boolean lighted;

    public boolean isLighted() {
        return lighted;
    }

    public void setLighted(boolean lighted) {
        lighted = lighted;
    }

    public LightEntity getLight() {
        return light;
    }

    public void setLight(LightEntity light) {
        this.light = light;
    }

    public CollectionPresetEntity getCollectionPreset() {
        return collectionPreset;
    }

    public void setCollectionPreset(CollectionPresetEntity collectionPreset) {
        this.collectionPreset = collectionPreset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPresetId() {
        return presetId;
    }

    public void setPresetId(String presetId) {
        this.presetId = presetId;
    }

}
