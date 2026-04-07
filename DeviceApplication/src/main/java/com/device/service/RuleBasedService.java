package com.device.service;

import com.device.dto.DeviceFilterDTO;
import org.springframework.stereotype.Service;

@Service
public class RuleBasedService {

    public DeviceFilterDTO parse(String prompt) {

        DeviceFilterDTO dto = new DeviceFilterDTO();
        prompt = prompt.toLowerCase();

        // Category detection
        if (prompt.contains("laptop") || prompt.contains("notebook")) dto.setCategory("laptop");
        else if (prompt.contains("phone") || prompt.contains("mobile")) dto.setCategory("phone");
        else if (prompt.contains("tv") || prompt.contains("television")) dto.setCategory("tv");
        else if (prompt.contains("refrigerator") || prompt.contains("fridge")) dto.setCategory("refrigerator");
        else if (prompt.contains("tablet")) dto.setCategory("tablet");
        else if (prompt.contains("camera")) dto.setCategory("camera");
        else if (prompt.contains("accessory")) dto.setCategory("accessory");

        // Brand detection
        if (prompt.contains("samsung")) dto.setBrand("Samsung");
        else if (prompt.contains("apple")) dto.setBrand("Apple");
        else if (prompt.contains("sony")) dto.setBrand("Sony");
        else if (prompt.contains("lg")) dto.setBrand("LG");
        else if (prompt.contains("dell")) dto.setBrand("Dell");

        // Price detection
        String[] words = prompt.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.matches("\\d+")) { // numeric value
                if (i > 0) {
                    String prev = words[i - 1];
                    if (prev.equalsIgnoreCase("above") || prev.equalsIgnoreCase("more")) {
                        dto.setPriceGreaterThan(Double.parseDouble(word));
                    } else if (prev.equalsIgnoreCase("under") || prev.equalsIgnoreCase("below")) {
                        dto.setPriceLessThan(Double.parseDouble(word));
                    }
                }
            }
        }

        return dto;
    }
}