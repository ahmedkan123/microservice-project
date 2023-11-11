package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.AddPatientDto;
import com.microservices.doctor.model.dto.PatientDto;
import com.microservices.doctor.service.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorPatientController {
    @Autowired
    private DoctorPatientService doctorPatientService;
    @GetMapping("/get-patient")
    public String getPatient() {
        return doctorPatientService.getPatient("Ali");
    }
    @GetMapping("/get-patient-feign")
    public String getPatientByFeignClient(@RequestParam String name) {
        return doctorPatientService.getPatientByFeignClient(name);
    }
    @GetMapping("/get-patient-by-doctor")
    public PatientDto getPatientByFeignClient(@RequestParam Long id) {
        return doctorPatientService.getPatient(id);
    }
    @PostMapping("/add-patient-by-doctor")
    public AddPatientDto getPatientByFeignClient(@RequestBody AddPatientDto dto) {
        return doctorPatientService.addPatient(dto);
    }

}
