package com.microservices.doctor.controller;

import com.microservices.doctor.service.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorPatientController {
    @Autowired
    private DoctorPatientService doctorPatientService;

    @GetMapping("/get-patient")
    public String getPatient() {
        return doctorPatientService.getPatient("Ali");
    }
}
