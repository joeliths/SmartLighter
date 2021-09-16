package com.gunnarsson.smartlighter.service;

import com.gunnarsson.smartlighter.shared.dto.CollectionPresetDto;
import com.gunnarsson.smartlighter.shared.dto.PresetDto;

import java.util.List;

public interface PresetService {
    CollectionPresetDto createCollectionPreset(CollectionPresetDto collectionPreset);
    List<String> executeCollectionPreset(String collectionPresetId);
    List<CollectionPresetDto> getAllCollectionPresets();
    PresetDto updatePreset(String id,PresetDto presetDto);
    void deleteLight(String collectionPresetId);
}
