package com.example.delivery_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery_drivers", schema = "food_delivery")
public class DeliveryDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    public DeliveryDriver() {}

    public DeliveryDriver(String name, String phone, String vehicleType) {
        this.name = name;
        this.phone = phone;
        this.vehicleType = vehicleType;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}

