package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.PaymentDTO;
import com.microservices.doctor.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientPaymentService {
    @Autowired
    private PaymentProxy paymentProxy;
    public PaymentDTO addPayment(AddPaymentDTO dto) {
        return paymentProxy.addPayment(dto);
    }
    public PaymentDTO getPayment(String transId) {
        return paymentProxy.getPayment(transId);
    }
}
