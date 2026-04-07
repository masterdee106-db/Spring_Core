package com.device.controller;

import com.device.entity.Device;
import com.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Autowired
    private DeviceService service;

    @PostMapping("/search")
    public List<Device> search(@RequestBody String prompt) {
        return service.searchByAI(prompt);
    }
}