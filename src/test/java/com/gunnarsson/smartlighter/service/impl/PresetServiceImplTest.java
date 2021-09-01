package com.gunnarsson.smartlighter.service.impl;

import com.gunnarsson.smartlighter.io.entity.CollectionPresetEntity;
import com.gunnarsson.smartlighter.io.repositories.CollectionPresetRepository;
import com.gunnarsson.smartlighter.shared.Utils;
import com.gunnarsson.smartlighter.shared.dto.CollectionPresetDto;
import com.gunnarsson.smartlighter.shared.dto.LightDto;
import com.gunnarsson.smartlighter.shared.dto.PresetDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class PresetServiceImplTest {

    @InjectMocks
    PresetServiceImpl presetService;

    @Mock
    CollectionPresetRepository collectionPresetRepository;

    @Mock
    Utils utils;

    CollectionPresetEntity collectionPresetEntity = new CollectionPresetEntity();
    CollectionPresetDto collectionPresetDto = new CollectionPresetDto();

    List<PresetDto> presetDtos = new ArrayList<>();
    LightDto lightDto1 = new LightDto();
    LightDto lightDto2 = new LightDto();
    LightDto lightDto3 = new LightDto();

    PresetDto presetDto1 = new PresetDto();
    PresetDto presetDto2 = new PresetDto();
    PresetDto presetDto3 = new PresetDto();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        setLightDtoValues();
        setPresetValues();
        setCollectionPresetDtoValues();
    }

    @Test
    void createCollectionPreset() {

        collectionPresetEntity = new ModelMapper().map(collectionPresetDto,CollectionPresetEntity.class);

        when(utils.generateCollectionPresetId(anyInt())).thenReturn(collectionPresetEntity.getCollectionPresetId());//
        when(collectionPresetRepository.save(any(CollectionPresetEntity.class))).thenReturn(collectionPresetEntity);

        CollectionPresetDto savedCollectionPresetDto = presetService.createCollectionPreset(collectionPresetDto);

        assertNotNull(savedCollectionPresetDto);
        assertEquals(collectionPresetEntity.getCollectionName(),savedCollectionPresetDto.getCollectionName());
        assertEquals(collectionPresetEntity.getCollectionPresetId(),savedCollectionPresetDto.getCollectionPresetId());
        assertEquals(collectionPresetEntity.getPresets().size(),savedCollectionPresetDto.getPresets().size());
    }

    private void setCollectionPresetDtoValues() {
        collectionPresetDto.setCollectionName("Kitchen");
        collectionPresetDto.setPresets(presetDtos);
        collectionPresetDto.setCollectionPresetId("167dhjhsgh");
    }

    private void setLightDtoValues() {

        lightDto1.setLightId("1");
        lightDto1.setLightName("test1");
        lightDto1.setIpAddress("111");

        lightDto2.setLightId("2");
        lightDto2.setLightName("test2");
        lightDto2.setIpAddress("222");

        lightDto3.setLightId("3");
        lightDto3.setLightName("test3");
        lightDto3.setIpAddress("333");
    }

    private void setPresetValues(){
        presetDto1.setPresetId("1");
        presetDto1.setLight(lightDto1);
        presetDto1.setOn(true);

        presetDto2.setPresetId("2");
        presetDto2.setLight(lightDto2);
        presetDto2.setOn(true);

        presetDto3.setPresetId("3");
        presetDto3.setLight(lightDto3);
        presetDto3.setOn(true);

        Collections.addAll(presetDtos,presetDto1,presetDto2,presetDto3);
        }

}