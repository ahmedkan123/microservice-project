package com.microservices.patient.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddPatientDto {
    private String patientName;
    private Integer patientAge;
}
