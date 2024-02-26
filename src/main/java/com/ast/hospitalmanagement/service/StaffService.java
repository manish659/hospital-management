package com.ast.hospitalmanagement.service;

import com.ast.hospitalmanagement.dtos.request.LoginStaffRequestDto;
import com.ast.hospitalmanagement.dtos.request.SignupStaffRequestDto;
import com.ast.hospitalmanagement.dtos.response.StaffResponseDto;
import com.ast.hospitalmanagement.entity.Staff;
import com.ast.hospitalmanagement.enums.StaffProfile;
import com.ast.hospitalmanagement.exceptions.UserNotFound;
import com.ast.hospitalmanagement.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public StaffResponseDto signupStaff(SignupStaffRequestDto signupStaffRequestDto) {
        Staff staff = Staff.builder()
                .fName(signupStaffRequestDto.getFName())
                .lName(signupStaffRequestDto.getLName())
                .phoneNo(signupStaffRequestDto.getPhoneNo())
                .password(signupStaffRequestDto.getPassword())
                .profile(signupStaffRequestDto.getProfile())
                .build();

        Staff st = staffRepository.save(staff);
        return StaffResponseDto.builder().id(st.getId()).fName(st.getFName()).lName(st.getLName())
                .phoneNo(st.getPhoneNo())
                .build();
    }

    public String loginStaff(LoginStaffRequestDto loginStaffRequestDto) throws UserNotFound {
        Staff staff = staffRepository.loginStaff(loginStaffRequestDto.getPhoneNo(), loginStaffRequestDto.getPassword());
        if (staff == null) {
            throw new UserNotFound("user not found");
        }
        return "user logged in successfully";
    }

    public List<StaffResponseDto> getAllDoctors() {
        List<Staff> doctors = staffRepository.getAllDoctors(StaffProfile.Doctor.getProfile());
        return doctors.stream().map(doctor -> StaffResponseDto.builder()
                .profile(doctor.getProfile())
                .phoneNo(doctor.getPhoneNo())
                .lName(doctor.getLName())
                .fName(doctor.getFName())
                .id(doctor.getId())
                .build()).toList();
    }
}
