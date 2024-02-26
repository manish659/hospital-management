package com.ast.hospitalmanagement.repository;

import com.ast.hospitalmanagement.entity.Patient;
import com.ast.hospitalmanagement.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    @Query("SELECT s FROM Staff s WHERE s.phoneNo = :phone_no and s.password = :password")
    Staff loginStaff(@Param("phone_no") String phone_no, @Param("password") String password);

    @Query("SELECT s FROM Staff s WHERE s.profile = :profile")
    List<Staff> getAllDoctors(@Param("profile") String profile);
}
