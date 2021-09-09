package com.gunnarsson.smartlighter.ui.controller;

import com.gunnarsson.smartlighter.service.LightService;
import com.gunnarsson.smartlighter.service.PresetService;
import com.gunnarsson.smartlighter.shared.dto.CollectionPresetDto;
import com.gunnarsson.smartlighter.shared.dto.PresetDto;
import com.gunnarsson.smartlighter.ui.model.request.LightStateModel;
import com.gunnarsson.smartlighter.ui.model.request.PresetLightsRequestModel;
import com.gunnarsson.smartlighter.ui.model.request.PresetRequestModel;
import com.gunnarsson.smartlighter.ui.model.response.CollectionPresetResponseModel;
import com.gunnarsson.smartlighter.ui.model.response.PresetResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/presets")
public class PresetController {

    @Autowired
    LightService lightService;

    @Autowired
    PresetService presetService;



    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public CollectionPresetDto createPreset (@RequestBody PresetLightsRequestModel presetLightsRequestModel){
        CollectionPresetDto collectionPresetDto = new CollectionPresetDto();
        collectionPresetDto.setPresets(SetPresetsToCollectionPreset(presetLightsRequestModel.getPresets()));
        collectionPresetDto.setCollectionName(presetLightsRequestModel.getCollectionName());
        CollectionPresetDto createdCollectionPreset = presetService.createCollectionPreset(collectionPresetDto);
        return createdCollectionPreset;
    }

    @PutMapping(path = "/{id}")
    public PresetResponseModel updatePreset(@PathVariable String id,@RequestBody PresetRequestModel presetRequestModel){
        PresetDto presetDto = new ModelMapper().map(presetRequestModel,PresetDto.class);
        PresetDto updatedPreset = presetService.updatePreset(id,presetDto);
        return new ModelMapper().map(updatedPreset,PresetResponseModel.class);
    }


    @GetMapping(path = "collection")
    public List<CollectionPresetResponseModel> getAllCollectionPresets(){
        List<CollectionPresetDto> collectionPresetDtoList = presetService.getAllCollectionPresets();
        Type listType = new TypeToken<List<CollectionPresetResponseModel>>(){}.getType();
        List<CollectionPresetResponseModel> collectionPresetResponseModelList = new ModelMapper().map(collectionPresetDtoList,listType);
        return collectionPresetResponseModelList;
    }


    private List<PresetDto> SetPresetsToCollectionPreset(List<LightStateModel> presets){
        List<PresetDto>presetDtos = new ArrayList<>();
        for(LightStateModel lightStateModel: presets){
            PresetDto presetDto = new PresetDto();
            presetDto.setOn(lightStateModel.isOn());
            presetDto.setLight(lightService.findLightByLightId(lightStateModel.getLightId()));
            presetDtos.add(presetDto);
        }
        return presetDtos;
    }


}
