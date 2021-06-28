package com.gunnarsson.smartlighter.service.impl;

import com.gunnarsson.smartlighter.io.entity.CollectionPresetEntity;
import com.gunnarsson.smartlighter.io.entity.PresetEntity;
import com.gunnarsson.smartlighter.io.repositories.CollectionPresetRepository;
import com.gunnarsson.smartlighter.io.repositories.LightRepository;
import com.gunnarsson.smartlighter.service.PresetService;
import com.gunnarsson.smartlighter.service.command.impl.LightOffCommand;
import com.gunnarsson.smartlighter.service.command.impl.LightOnCommand;
import com.gunnarsson.smartlighter.shared.Utils;
import com.gunnarsson.smartlighter.shared.dto.CollectionPresetDto;
import com.gunnarsson.smartlighter.shared.dto.LightDto;
import com.gunnarsson.smartlighter.shared.dto.PresetDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PresetServiceImpl implements PresetService {

    @Autowired
    CollectionPresetRepository collectionPresetRepository;

    @Autowired
    LightRepository lightRepository;

    @Autowired
    Utils utils;

    @Override
    public CollectionPresetDto createCollectionPreset(CollectionPresetDto collectionPreset) {

        for(PresetDto presetDto:collectionPreset.getPresets()){
            presetDto.setCollectionPreset(collectionPreset);
            presetDto.setPresetId(utils.generateId(10));
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CollectionPresetEntity collectionPresetEntity = modelMapper.map(collectionPreset,CollectionPresetEntity.class);
        collectionPresetEntity.setCollectionPresetId(utils.generateCollectionPresetId(10));

        CollectionPresetEntity savedCollection = collectionPresetRepository.save(collectionPresetEntity);
        return modelMapper.map(savedCollection,CollectionPresetDto.class);
    }

    @Override
    public List<String> executePreset(String collectionPresetId) {
        CollectionPresetEntity collectionPresetEntity = collectionPresetRepository.findPresetBycollectionPresetId(collectionPresetId);
        List<String> returnValue = new ArrayList<>();
        for (PresetEntity presetEntity : collectionPresetEntity.getPresets()) {
            returnValue.add(createCommand(presetEntity));
        }
        return returnValue;
    }

    private String createCommand(PresetEntity presetEntity){
        LightDto lightDto = new ModelMapper().map(presetEntity,LightDto.class);
        if(presetEntity.isLighted()) return new LightOnCommand(lightDto).execute();
        return new LightOffCommand(lightDto).execute();
    }
}
