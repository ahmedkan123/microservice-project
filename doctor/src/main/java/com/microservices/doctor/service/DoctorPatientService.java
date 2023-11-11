package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.AddPatientDto;
import com.microservices.doctor.model.dto.PatientDto;
import com.microservices.doctor.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorPatientService {
    @Autowired
    private PatientProxy patientProxy;
    public String getPatient(String name) {
        String fullUrl = "http://localhost:9000/patients/search/"+ name;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(fullUrl, String.class);
    }
    public String getPatientByFeignClient(String name) {
        return patientProxy.getName(name);
    }
    public PatientDto getPatient(Long id) {
        return patientProxy.get(id);
    }
    public AddPatientDto addPatient(AddPatientDto dto) {
        return patientProxy.save(dto);
    }
}
