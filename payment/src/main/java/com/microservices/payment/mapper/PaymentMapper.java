package com.microservices.payment.mapper;

import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toEntity(PaymentDTO dto);
    PaymentDTO toDTO(Payment entity);
    List<PaymentDTO> toDTOs(List<Payment> entities);
    List<Payment> toEntities(List<PaymentDTO> dtos);
}
