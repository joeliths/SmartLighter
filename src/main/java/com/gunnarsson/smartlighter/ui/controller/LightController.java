package com.gunnarsson.smartlighter.ui.controller;

import com.gunnarsson.smartlighter.service.LightService;
import com.gunnarsson.smartlighter.shared.dto.LightDto;
import com.gunnarsson.smartlighter.ui.model.request.LightRequestModel;
import com.gunnarsson.smartlighter.ui.model.response.LightResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lights")
public class LightController {
    @Autowired
    LightService lightService;

    @GetMapping
    public String turnOnLight(@RequestParam String lightId){
        return lightService.turnOn(lightId);
    }

    @PostMapping
    public LightResponseModel createLight(@RequestBody LightRequestModel lightRequestModel){
        LightDto lightDto = new ModelMapper().map(lightRequestModel,LightDto.class);
        LightDto createdLight = lightService.createLight(lightDto);
        return new ModelMapper().map(createdLight,LightResponseModel.class);
    }
}
