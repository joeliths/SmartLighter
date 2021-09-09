package com.gunnarsson.smartlighter.ui.controller;

import com.gunnarsson.smartlighter.service.LightService;
import com.gunnarsson.smartlighter.service.PresetService;
import com.gunnarsson.smartlighter.shared.dto.CollectionPresetDto;
import com.gunnarsson.smartlighter.shared.dto.LightDto;
import com.gunnarsson.smartlighter.shared.dto.PresetDto;
import com.gunnarsson.smartlighter.ui.model.request.LightRequestModel;
import com.gunnarsson.smartlighter.ui.model.request.LightStateModel;
import com.gunnarsson.smartlighter.ui.model.request.PresetLightsRequestModel;
import com.gunnarsson.smartlighter.ui.model.response.CollectionPresetResponseModel;
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


    @GetMapping
    public List<LightResponseModel> getAllLights(){
        List<LightDto> lightDtoList = lightService.getAllLights();
        Type listType = new TypeToken<List<LightResponseModel>>(){}.getType();
        return new ModelMapper().map(lightDtoList,listType);
    }

    @GetMapping(path = "/{id}")
    public LightResponseModel findLightByLightId(@PathVariable String id){
        LightDto lightDto = lightService.findLightByLightId(id);
        return new ModelMapper().map(lightDto,LightResponseModel.class);
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

}
