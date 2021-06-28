package com.gunnarsson.smartlighter.service;

import com.gunnarsson.smartlighter.shared.dto.LightDto;

import java.util.List;

public interface LightService {
    LightDto findLightByLightId(String lightId);
    LightDto createLight(LightDto light);
    String turnOn(String id);
    List<LightDto> getAllLights();
}
