package com.example.delivery_service.service;

import com.example.delivery_service.dto.DeliveryDriverRequest;
import com.example.delivery_service.dto.DeliveryDriverResponse;

import java.util.List;

public interface DeliveryDriverService {

    DeliveryDriverResponse createDriver(DeliveryDriverRequest request);

    List<DeliveryDriverResponse> getAllDrivers();

    DeliveryDriverResponse getDriverById(Long id);

    void deleteDriver(Long id);

    DeliveryDriverResponse updateDriver(Long id, DeliveryDriverRequest request);
}


