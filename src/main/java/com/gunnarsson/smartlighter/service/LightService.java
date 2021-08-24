package com.gunnarsson.smartlighter.service;

import com.gunnarsson.smartlighter.shared.dto.LightDto;

import java.util.List;

public interface LightService {
    LightDto findLightByLightId(String lightId);
    LightDto createLight(LightDto light);
    void deleteLight(String lightId);
    String turnOn(String id);
    String turnOff(String lightId);
    List<LightDto> getAllLights();
}
