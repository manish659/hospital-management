package com.ast.hospitalmanagement.controller;

import com.ast.hospitalmanagement.dtos.request.LoginStaffRequestDto;
import com.ast.hospitalmanagement.dtos.request.SignupStaffRequestDto;
import com.ast.hospitalmanagement.dtos.response.StaffResponseDto;
import com.ast.hospitalmanagement.exceptions.UserNotFound;
import com.ast.hospitalmanagement.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/signup")
    public ResponseEntity<StaffResponseDto> signupStaff(@RequestBody @Valid SignupStaffRequestDto signupStaffRequestDto) {
        StaffResponseDto staff = staffService.signupStaff(signupStaffRequestDto);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStaff(@RequestBody @Valid LoginStaffRequestDto loginStaffRequestDto) {
        try {
            String response = staffService.loginStaff(loginStaffRequestDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UserNotFound ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all-doctors")
    public ResponseEntity<List<StaffResponseDto>> getAllDoctors() {
        List<StaffResponseDto> staff = staffService.getAllDoctors();
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
}
