package com.gunnarsson.smartlighter.service;

import com.gunnarsson.smartlighter.shared.dto.LightDto;

public interface LightService {
    LightDto createLight(LightDto light);
    String turnOn(String id);
}
