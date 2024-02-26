package com.ast.hospitalmanagement.controller;

import com.ast.hospitalmanagement.dtos.request.AdmitPatientRequestDto;
import com.ast.hospitalmanagement.dtos.request.DischargePatientRequestDto;
import com.ast.hospitalmanagement.dtos.response.PatientsResponseDto;
import com.ast.hospitalmanagement.entity.Patient;
import com.ast.hospitalmanagement.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/admit")
    public ResponseEntity<Patient> admitPatient(@RequestBody @Valid AdmitPatientRequestDto addPatientRequestDto) {
        Patient patient = patientService.admitPatient(addPatientRequestDto);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PatientsResponseDto>> getAllPatients() {
        List<PatientsResponseDto> patientsResponseDtos = patientService.getAdmittedPatients();
        return new ResponseEntity<>(patientsResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/discharge")
    public ResponseEntity<String> dischargePatient(@RequestBody @Valid DischargePatientRequestDto dischargePatientRequestDto) {
        String response = patientService.dischargePatient(dischargePatientRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
