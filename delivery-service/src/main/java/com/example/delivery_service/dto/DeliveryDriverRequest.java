package com.example.delivery_service.dto;

public class DeliveryDriverRequest {

    private String name;
    private String phone;
    private String vehicleType;

    public DeliveryDriverRequest() {}

    public DeliveryDriverRequest(String name, String phone, String vehicleType) {
        this.name = name;
        this.phone = phone;
        this.vehicleType = vehicleType;
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

