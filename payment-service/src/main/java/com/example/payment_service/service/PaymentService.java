package com.example.payment_service.service;

import com.example.payment_service.dto.CreatePaymentDTO;
import com.example.payment_service.dto.PaymentDTO;
import com.example.payment_service.dto.UpdatePaymentDTO;

import java.util.List;

public interface PaymentService {

    PaymentDTO createPayment(CreatePaymentDTO dto);

    PaymentDTO updatePaymentStatus(Long paymentId, UpdatePaymentDTO dto);

    PaymentDTO getPaymentById(Long paymentId);

    List<PaymentDTO> getPaymentsByOrderId(Long orderId);
}

