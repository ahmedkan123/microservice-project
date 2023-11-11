package com.microservices.payment.service;

import com.microservices.payment.mapper.PaymentMapper;
import com.microservices.payment.model.dto.AddPaymentDTO;
import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.entity.Payment;
import com.microservices.payment.model.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private PaymentMapper paymentMapper;
    public PaymentDTO addPayment(AddPaymentDTO dto) {
        String transId = UUID.randomUUID().toString();
        PaymentDTO payment = PaymentDTO.builder()
                .amount(dto.getAmount())
                .patientId(dto.getPatientId())
                .transId(transId)
                .build();
        Payment entity = paymentMapper.toEntity(payment);
        Payment savedPayment = paymentRepo.save(entity);
        return paymentMapper.toDTO(savedPayment);
    }
    public PaymentDTO getPayment(String transId) {
        Optional<Payment> payment = paymentRepo.findByTransId(transId);
        return paymentMapper.toDTO(payment.get());
    }
    public List<PaymentDTO> getPatientPayments(Long patientId){
        List<Payment> payments = this.paymentRepo.findAllByPatientId(patientId);
        return this.paymentMapper.toDTOs(payments);
    }

}
