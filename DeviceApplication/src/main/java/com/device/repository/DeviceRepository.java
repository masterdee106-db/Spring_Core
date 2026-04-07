package com.device.repository;

import com.device.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByPriceGreaterThan(double price);
    List<Device> findByBrandContainingIgnoreCase(String brand);
    List<Device> findByCategoryIgnoreCase(String category);
}
