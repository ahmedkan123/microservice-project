package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.AddPaymentDTO;
import com.microservices.doctor.model.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PAYMENT-SERVICE", path = "/payment")
public interface PaymentProxy {
    @PostMapping("/payments/add-payment")
    PaymentDTO addPayment(@RequestBody AddPaymentDTO dto);
    @GetMapping("/payments/get-payment")
    PaymentDTO getPayment(@RequestParam String transId);
}
