package com.device.controller;

import com.device.entity.Device;
import com.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService service;

    // Create new device
    @PostMapping
    public Device create(@RequestBody Device device) {
        return service.create(device);
    }

    // Get all devices
    @GetMapping
    public List<Device> getAll() {
        return service.getAllDevice();
    }
}