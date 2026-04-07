package com.device.service;

import com.device.dto.DeviceFilterDTO;
import com.device.entity.Device;
import com.device.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repository;

    @Autowired
    private RuleBasedService ruleService;

    @Autowired
    private AIService aiService;

    // Strict search by AI or rule-based parsing
    public List<Device> searchByAI(String prompt) {

        // Parse using rules first
        DeviceFilterDTO dto = ruleService.parse(prompt);

        // If rule fails, use AI
        if (dto.getCategory() == null && dto.getBrand() == null && dto.getPriceGreaterThan() == null && dto.getPriceLessThan() == null) {
            dto = aiService.convertPrompt(prompt);
        }

        DeviceFilterDTO finalDto = dto;

        // Strict filtering using streams
        return repository.findAll().stream()
                // Category filter
                .filter(device -> finalDto.getCategory() == null || device.getCategory().equalsIgnoreCase(finalDto.getCategory()))
                // Brand filter
                .filter(device -> finalDto.getBrand() == null || device.getBrand().equalsIgnoreCase(finalDto.getBrand()))
                // Price greater than filter
                .filter(device -> finalDto.getPriceGreaterThan() == null || device.getPrice() > finalDto.getPriceGreaterThan())
                // Price less than filter
                .filter(device -> finalDto.getPriceLessThan() == null || device.getPrice() < finalDto.getPriceLessThan())
                .toList();
    }

    // Save device
    public Device create(Device device) {
        return repository.save(device);
    }

    // Get all devices
    public List<Device> getAllDevice() {
        return repository.findAll();
    }
}