package com.ast.hospitalmanagement.service;

import com.ast.hospitalmanagement.dtos.request.AdmitPatientRequestDto;
import com.ast.hospitalmanagement.dtos.request.DischargePatientRequestDto;
import com.ast.hospitalmanagement.dtos.response.PatientsResponseDto;
import com.ast.hospitalmanagement.entity.Patient;
import com.ast.hospitalmanagement.entity.Room;
import com.ast.hospitalmanagement.enums.PatientStatus;
import com.ast.hospitalmanagement.enums.RoomStatus;
import com.ast.hospitalmanagement.repository.PatientRepository;
import com.ast.hospitalmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    private final RoomRepository roomRepository;

    public PatientService(PatientRepository patientRepository, RoomRepository roomRepository) {
        this.patientRepository = patientRepository;
        this.roomRepository = roomRepository;
    }

    public Patient admitPatient(AdmitPatientRequestDto admitPatientRequestDto) {
        roomRepository.updateStatusByRoomId(admitPatientRequestDto.getRoomId(),
                RoomStatus.OCCUPIED.getRoomStatus());

        Patient patient = Patient.builder().name(admitPatientRequestDto.getName())
                .age(admitPatientRequestDto.getAge())
                .admitDate(LocalDateTime.parse(LocalDateTime.now().toString(), DateTimeFormatter.ISO_DATE_TIME))
                .roomId(admitPatientRequestDto.getRoomId())
                .doctorName(admitPatientRequestDto.getDoctorName())
                .status(PatientStatus.ADMITTED.getPatientStatus())
                .phoneNo(admitPatientRequestDto.getPhoneNo())
                .build();
        return patientRepository.save(patient);
    }

    public List<PatientsResponseDto> getAdmittedPatients() {
        List<Patient> patients = patientRepository.findAdmittedPatient(PatientStatus.ADMITTED.getPatientStatus());
        return patients.stream().map(patient -> PatientsResponseDto.builder()
                .id(patient.getId())
                .roomId(patient.getRoomId())
                .age(patient.getAge())
                .doctorName(patient.getDoctorName())
                .admitDate(patient.getAdmitDate())
                .name(patient.getName())
                .build()).toList();
    }

    public String dischargePatient(DischargePatientRequestDto dischargePatientRequestDto) {
        roomRepository.updateStatusByRoomId(dischargePatientRequestDto.getRoomId(),
                RoomStatus.AVAILABLE.getRoomStatus());

        patientRepository.updateStatusByPatientId(dischargePatientRequestDto.getId(),
                PatientStatus.DISCHARGED.getPatientStatus());
        return "Patient discharged successfully";
    }
}
