package com.example.delivery_service.repository;

import com.example.delivery_service.model.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Long> {
    boolean existsByPhone(String phone);
}

