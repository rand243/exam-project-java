package com.example.payment_service.service.impl;

import com.example.payment_service.dto.CreatePaymentDTO;
import com.example.payment_service.dto.PaymentDTO;
import com.example.payment_service.dto.UpdatePaymentDTO;
import com.example.payment_service.model.Payment;
import com.example.payment_service.repository.PaymentRepository;
import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentDTO createPayment(CreatePaymentDTO dto) {
        Payment payment = new Payment();
        payment.setOrderId(dto.getOrderId());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setPaymentStatus("Pending");

        Payment saved = paymentRepository.save(payment);
        return mapToDTO(saved);
    }

    @Override
    public PaymentDTO updatePaymentStatus(Long paymentId, UpdatePaymentDTO dto) {
        Optional<Payment> optional = paymentRepository.findById(paymentId);
        if (optional.isEmpty()) {
            throw new RuntimeException("Payment not found");
        }

        Payment payment = optional.get();
        payment.setPaymentStatus(dto.getPaymentStatus());

        Payment updated = paymentRepository.save(payment);
        return mapToDTO(updated);
    }

    @Override
    public PaymentDTO getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public List<PaymentDTO> getPaymentsByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private PaymentDTO mapToDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setPaymentId(payment.getPaymentId());
        dto.setOrderId(payment.getOrderId());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setPaymentStatus(payment.getPaymentStatus());
        return dto;
    }
}

