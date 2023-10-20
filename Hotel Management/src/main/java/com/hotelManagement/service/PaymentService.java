package com.hotelManagement.service;

import com.hotelManagement.model.Payment;
import com.hotelManagement.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public String reservationPayment(Payment payment) {
        paymentRepository.save(payment);
        return "Payment done";
    }
}
