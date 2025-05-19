package com.example.payment_service.controller;

import com.example.payment_service.dto.CreatePaymentDTO;
import com.example.payment_service.dto.PaymentDTO;
import com.example.payment_service.dto.UpdatePaymentDTO;
import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody CreatePaymentDTO dto) {
        PaymentDTO payment = paymentService.createPayment(dto);
        return ResponseEntity.ok(payment);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PaymentDTO> updatePaymentStatus(
            @PathVariable("id") Long paymentId,
            @RequestBody UpdatePaymentDTO dto) {
        PaymentDTO updated = paymentService.updatePaymentStatus(paymentId, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable("id") Long paymentId) {
        PaymentDTO payment = paymentService.getPaymentById(paymentId);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PaymentDTO>> getPaymentsByOrderId(@PathVariable("orderId") Long orderId) {
        List<PaymentDTO> payments = paymentService.getPaymentsByOrderId(orderId);
        return ResponseEntity.ok(payments);
    }
}

