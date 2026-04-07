package com.device.dto;

import lombok.Data;

@Data
public class DeviceFilterDTO {

    private String category;
    private String brand;

    private Double priceGreaterThan;
    private Double priceLessThan;

    private String sortBy; // cheap / expensive / latest
}