package com.example.order_service.repository;

import com.example.order_service.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderOrderId(Long orderId);
}


