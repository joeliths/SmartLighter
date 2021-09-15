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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/presets")
public class PresetController {

    @Autowired
    LightService lightService;

    @Autowired
    PresetService presetService;

    @PostMapping(path = "collection",consumes= MediaType.APPLICATION_JSON_VALUE)
    public CollectionPresetResponseModel createCollectionPreset(@RequestBody PresetLightsRequestModel presetLightsRequestModel){
        CollectionPresetDto collectionPresetDto = new CollectionPresetDto();
        collectionPresetDto.setPresets(SetPresetsToCollectionPreset(presetLightsRequestModel.getPresets()));
        collectionPresetDto.setCollectionName(presetLightsRequestModel.getCollectionName());
        CollectionPresetDto createdCollectionPreset = presetService.createCollectionPreset(collectionPresetDto);
        return new ModelMapper().map(createdCollectionPreset,CollectionPresetResponseModel.class);
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

    @DeleteMapping(path = "collection/{id}")
    public Map<String, Boolean> deleteCollectionPreset (@PathVariable String collectionPresetId){
        presetService.deleteLight(collectionPresetId);
        Map<String, Boolean> response = new HashMap<>();
        response.put(collectionPresetId, Boolean.TRUE);
        return response;
    }


    private List<PresetDto> SetPresetsToCollectionPreset(List<LightStateModel> presets){
        List<PresetDto>presetDtos = new ArrayList<>();
        for(LightStateModel lightStateModel: presets){
            PresetDto presetDto = new PresetDto();
            presetDto.setLighted(lightStateModel.isOn());
            presetDto.setLight(lightService.findLightByLightId(lightStateModel.getLightId()));
            presetDtos.add(presetDto);
        }
        return presetDtos;
    }


}
