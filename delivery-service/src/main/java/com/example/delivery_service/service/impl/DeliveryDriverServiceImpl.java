package com.example.delivery_service.service.impl;

import com.example.delivery_service.dto.DeliveryDriverRequest;
import com.example.delivery_service.dto.DeliveryDriverResponse;
import com.example.delivery_service.model.DeliveryDriver;
import com.example.delivery_service.repository.DeliveryDriverRepository;
import com.example.delivery_service.service.DeliveryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryDriverServiceImpl implements DeliveryDriverService {

    private final DeliveryDriverRepository driverRepository;

    @Autowired
    public DeliveryDriverServiceImpl(DeliveryDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DeliveryDriverResponse createDriver(DeliveryDriverRequest request) {
        DeliveryDriver driver = new DeliveryDriver();
        driver.setName(request.getName());
        driver.setPhone(request.getPhone());
        driver.setVehicleType(request.getVehicleType());

        DeliveryDriver saved = driverRepository.save(driver);
        return mapToResponse(saved);
    }

    @Override
    public List<DeliveryDriverResponse> getAllDrivers() {
        return driverRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDriverResponse getDriverById(Long id) {
        Optional<DeliveryDriver> driverOpt = driverRepository.findById(id);
        return driverOpt.map(this::mapToResponse).orElse(null);
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }

    @Override
    public DeliveryDriverResponse updateDriver(Long id, DeliveryDriverRequest request) {
        Optional<DeliveryDriver> existingOpt = driverRepository.findById(id);
        if (existingOpt.isPresent()) {
            DeliveryDriver driver = existingOpt.get();
            driver.setName(request.getName());
            driver.setPhone(request.getPhone());
            driver.setVehicleType(request.getVehicleType());
            return mapToResponse(driverRepository.save(driver));
        }
        return null;
    }

    private DeliveryDriverResponse mapToResponse(DeliveryDriver driver) {
        DeliveryDriverResponse response = new DeliveryDriverResponse();
        response.setDriverId(driver.getDriverId());
        response.setName(driver.getName());
        response.setPhone(driver.getPhone());
        response.setVehicleType(driver.getVehicleType());
        return response;
    }
}

