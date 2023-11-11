package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.AddPatientDto;
import com.microservices.doctor.model.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "PATIENT-SERVICE", path = "/patient")
public interface PatientProxy {
    @GetMapping("/patients/search/{name}")
    String getName(@PathVariable("name") String name);
    @GetMapping("/patients/get-patient")
    PatientDto get(@RequestParam Long id);
    @PostMapping("/patients/add-patient")
    AddPatientDto save(@RequestBody AddPatientDto dto);
}
