package com.ast.hospitalmanagement.repository;

import com.ast.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("SELECT p FROM Patient p WHERE p.status = :status")
    List<Patient> findAdmittedPatient(@Param("status") String status);

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.status= :status where p.id=:id")
    void updateStatusByPatientId(@Param("id") Integer room_id, @Param("status") String status);
}
