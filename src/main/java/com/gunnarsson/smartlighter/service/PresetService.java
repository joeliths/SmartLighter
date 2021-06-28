package com.gunnarsson.smartlighter.service;

import com.gunnarsson.smartlighter.shared.dto.CollectionPresetDto;

import java.util.List;

public interface PresetService {
    CollectionPresetDto createCollectionPreset(CollectionPresetDto collectionPreset);
    List<String> executePreset(String collectionPresetId);
}
