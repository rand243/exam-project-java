package com.example.delivery_service.controller;

import com.example.delivery_service.dto.DeliveryDriverRequest;
import com.example.delivery_service.dto.DeliveryDriverResponse;
import com.example.delivery_service.service.DeliveryDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DeliveryDriverController {

    private final DeliveryDriverService driverService;

    @Autowired
    public DeliveryDriverController(DeliveryDriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<DeliveryDriverResponse> createDriver(@RequestBody DeliveryDriverRequest request) {
        return ResponseEntity.ok(driverService.createDriver(request));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDriverResponse>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDriverResponse> getDriverById(@PathVariable Long id) {
        DeliveryDriverResponse response = driverService.getDriverById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDriverResponse> updateDriver(@PathVariable Long id,
                                                               @RequestBody DeliveryDriverRequest request) {
        DeliveryDriverResponse updated = driverService.updateDriver(id, request);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}

