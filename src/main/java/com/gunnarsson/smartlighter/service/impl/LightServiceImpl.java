package com.gunnarsson.smartlighter.service.impl;

import com.gunnarsson.smartlighter.io.entity.LightEntity;
import com.gunnarsson.smartlighter.io.repositories.LightRepository;
import com.gunnarsson.smartlighter.service.LightService;
import com.gunnarsson.smartlighter.service.command.impl.LightOffCommand;
import com.gunnarsson.smartlighter.service.command.impl.LightOnCommand;
import com.gunnarsson.smartlighter.shared.Utils;
import com.gunnarsson.smartlighter.shared.dto.LightDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class LightServiceImpl implements LightService {

    @Autowired
    LightRepository lightRepository;

    @Autowired
    Utils utils;

    @Override
    public LightDto findLightByLightId(String lightId) {
        LightEntity lightEntity = lightRepository.findLightByLightId(lightId);
        return new ModelMapper().map(lightEntity,LightDto.class);
    }

    @Override
    public LightDto createLight(LightDto light) {
        LightEntity lightEntity = new ModelMapper().map(light,LightEntity.class);
        lightEntity.setLightId(utils.generateLightId(10));
        LightEntity savedLight = lightRepository.save(lightEntity);
        return new ModelMapper().map(savedLight,LightDto.class);

    }

    @Override
    public void deleteLight(LightDto light) {
        LightEntity lightEntity = new ModelMapper().map(light,LightEntity.class);
        lightRepository.delete(lightEntity);
    }

    @Override
    public String turnOn(String lightId) {
       LightEntity light = lightRepository.findLightByLightId(lightId);
        LightDto lightDto = new ModelMapper().map(light,LightDto.class);
        return new LightOnCommand(lightDto).execute();
    }

    @Override
    public String turnOff(String lightId) {
        LightEntity light = lightRepository.findLightByLightId(lightId);
        LightDto lightDto = new ModelMapper().map(light,LightDto.class);
        return new LightOffCommand(lightDto).execute();
    }

    @Override
    public List<LightDto> getAllLights() {
        List<LightEntity> lights = (List<LightEntity>) lightRepository.findAll();
        Type listType = new TypeToken<List<LightDto>>(){}.getType();
        List<LightDto> lightDtoList = new ModelMapper().map(lights,listType);
        return lightDtoList;
    }
}
