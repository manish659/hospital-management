package com.ast.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "admit_date")
    private LocalDateTime admitDate;

    @Column(name = "expenses")
    private Integer expenses;

    @Column(name = "status")
    private String status;

    @Column(name = "phone_no")
    private String phoneNo;
}
