package com.microservices.patient.controller;

import com.microservices.patient.model.dto.AddPatientDto;
import com.microservices.patient.model.dto.PatientDto;
import com.microservices.patient.model.dto.PaymentDTO;
import com.microservices.patient.model.dto.UpdatePatientDto;
import com.microservices.patient.service.PatientPaymentService;
import com.microservices.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Slf4j
public class PatientController {

    private final PatientService patientService;
    @Autowired
    private PatientPaymentService paymentService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/search/{name}")
    public String getName(@PathVariable("name") String name) {
        log.info("new request "+ UUID.randomUUID());
        return patientService.getName(name) + " From Service One";
    }
    @PostMapping("/add-patient")
    public AddPatientDto save(@RequestBody AddPatientDto dto) {
        return patientService.save(dto);
    }
    @PutMapping("/update-patient")
    public PatientDto update(@RequestBody UpdatePatientDto dto) {
        return patientService.update(dto);
    }
    @DeleteMapping("/delete-patient")
    public void delete(@RequestParam Long id) {
        patientService.delete(id);
    }
    @GetMapping("/get-patient")
    public PatientDto get(@RequestParam Long id) {
        return patientService.get(id);
    }
    @GetMapping("/getAll-patient")
    public List<PatientDto> getAll() {
        return patientService.getAll();
    }
    @GetMapping("/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestHeader("id") Long id){
        return this.paymentService.getPatientPayments(id);
    }
}
