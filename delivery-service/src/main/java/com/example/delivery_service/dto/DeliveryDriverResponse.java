package com.example.delivery_service.dto;

public class DeliveryDriverResponse {

    private Long driverId;
    private String name;
    private String phone;
    private String vehicleType;

    public DeliveryDriverResponse() {}

    public DeliveryDriverResponse(Long driverId, String name, String phone, String vehicleType) {
        this.driverId = driverId;
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
