package com.microservices.patient.service;

import com.microservices.patient.model.dto.AddPatientDto;
import com.microservices.patient.model.dto.PatientDto;
import com.microservices.patient.model.dto.UpdatePatientDto;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.model.mapper.PatientMapper;
import com.microservices.patient.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private PatientMapper patientMapper;
    private List<String> names = Arrays.asList("Ahmed", "Ibrahim", "Hatem");

    public String getName(String name) {
        return names.stream()
                .filter(n -> n.equals(name))
                .findAny()
                .orElse("Patient not found");
    }
    public AddPatientDto save(AddPatientDto dto) {
        Patient entity = patientMapper.toEntity(dto);
        Patient patient = patientRepo.save(entity);
        return patientMapper.toAddDTO(patient);
    }
    public PatientDto update(UpdatePatientDto dto) {
        Patient entity = patientMapper.toUpdateDTO(dto);
        Patient patient = patientRepo.save(entity);
        return patientMapper.toDTO(patient);
    }
    public void delete(Long id) {
        patientRepo.deleteById(id);
    }
    public PatientDto get(Long id) {
        Optional<Patient> patient = patientRepo.findById(id);
        return patientMapper.toDTO(patient.get());
    }
    public List<PatientDto> getAll() {
        return patientRepo.findAll()
                .stream()
                .map(patient -> patientMapper.toDTO(patient))
                .collect(Collectors.toList());
    }

}
