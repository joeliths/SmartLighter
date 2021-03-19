package com.gunnarsson.smartlighter.service.command.impl;

import com.gunnarsson.smartlighter.service.command.Command;
import com.gunnarsson.smartlighter.shared.dto.LightDto;

public class LightOnCommand implements Command {
    private LightDto lightDto;

    public LightOnCommand(LightDto lightDto) {
        this.lightDto = lightDto;
    }

    @Override
    public String execute() {
        return lightDto.getLightName()+" light on";
    }
}
