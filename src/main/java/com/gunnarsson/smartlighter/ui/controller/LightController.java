package com.gunnarsson.smartlighter.ui.controller;

import com.gunnarsson.smartlighter.service.LightService;
import com.gunnarsson.smartlighter.service.PresetService;
import com.gunnarsson.smartlighter.shared.dto.CollectionPresetDto;
import com.gunnarsson.smartlighter.shared.dto.LightDto;
import com.gunnarsson.smartlighter.shared.dto.PresetDto;
import com.gunnarsson.smartlighter.ui.model.request.LightRequestModel;
import com.gunnarsson.smartlighter.ui.model.request.LightStateModel;
import com.gunnarsson.smartlighter.ui.model.request.PresetLightsRequestModel;
import com.gunnarsson.smartlighter.ui.model.response.LightResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lights")
public class LightController {
    @Autowired
    LightService lightService;

    @Autowired
    PresetService presetService;

    @GetMapping
    public List<LightResponseModel> getAllLights(){
        List<LightDto> lightDtoList = lightService.getAllLights();
        Type listType = new TypeToken<List<LightResponseModel>>(){}.getType();
        return new ModelMapper().map(lightDtoList,listType);
    }

    @GetMapping(path = "on")
    public String turnOnLight(@RequestParam String lightId){
        return lightService.turnOn(lightId);
    }

    @GetMapping(path = "off")
    public String turnOffLight(@RequestParam String lightId){
        return lightService.turnOff(lightId);
    }

    @PostMapping
    public LightResponseModel createLight(@RequestBody LightRequestModel lightRequestModel){
        LightDto lightDto = new ModelMapper().map(lightRequestModel,LightDto.class);
        LightDto createdLight = lightService.createLight(lightDto);
        return new ModelMapper().map(createdLight,LightResponseModel.class);
    }

    @PostMapping(path = "preset",consumes= MediaType.APPLICATION_JSON_VALUE)
    public CollectionPresetDto createPreset (@RequestBody PresetLightsRequestModel presetLightsRequestModel){
        CollectionPresetDto collectionPresetDto = new CollectionPresetDto();
        collectionPresetDto.setPresets(SetPresetsToCollectionPreset(presetLightsRequestModel.getPresets()));
        collectionPresetDto.setCollectionName(presetLightsRequestModel.getCollectionName());
        CollectionPresetDto createdCollectionPreset = presetService.createCollectionPreset(collectionPresetDto);
        return createdCollectionPreset;
    }

    @DeleteMapping(path = "/{id}")
    public Map<String, Boolean> deleteLight (@PathVariable String lightId){
        lightService.deleteLight(lightId);
        Map<String, Boolean> response = new HashMap<>();
        response.put(lightId, Boolean.TRUE);
        return response;
    }

    @PutMapping(path = "/{id}")
    public LightResponseModel updateLight(@PathVariable String id, @RequestBody LightRequestModel lightRequestModel){
        LightDto lightDto = new ModelMapper().map(lightRequestModel,LightDto.class);
        LightDto updatedLight  = lightService.updateLight(id,lightDto);
        return new ModelMapper().map(updatedLight,LightResponseModel.class);
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
