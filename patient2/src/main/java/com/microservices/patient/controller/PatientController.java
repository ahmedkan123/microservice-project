package com.microservices.patient.controller;

import com.microservices.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Slf4j
public class PatientController {

    private final PatientService patientService;

    @Autowired
    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/search/{name}")
    public String getName(@PathVariable("name") String name) {
        log.info("new request "+ UUID.randomUUID());
        return patientService.getName(name) + " From Service Two";
    }
}
