package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.PaymentDTO;
import com.microservices.doctor.service.PatientPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PatientPaymentController {
    @Autowired
    private PatientPaymentService patientPayment;
    @PostMapping("/add-payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO dto) {
        return patientPayment.addPayment(dto);
    }
    @GetMapping("/payment-by-trans")
    public PaymentDTO getPayment(@RequestParam String transId) {
        return patientPayment.getPayment(transId);
    }
}
