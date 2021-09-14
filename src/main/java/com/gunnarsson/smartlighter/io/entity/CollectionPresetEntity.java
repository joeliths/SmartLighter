package com.gunnarsson.smartlighter.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="collection_preset")
public class CollectionPresetEntity implements Serializable {
    private static final long serialVersionUID = 1513728765113026L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String collectionPresetId;

    @Column(nullable=false, length=30)
    private String collectionName;

   @OneToMany(mappedBy="collectionPresetEntity",cascade = CascadeType.ALL)
    private List<PresetEntity> presets;

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollectionPresetId() {
        return collectionPresetId;
    }

    public void setCollectionPresetId(String presetId) {
        this.collectionPresetId = presetId;
    }

    public List<PresetEntity> getPresets() {
        return presets;
    }

    public void setPresets(List<PresetEntity> presets) {
        this.presets = presets;
    }

}
