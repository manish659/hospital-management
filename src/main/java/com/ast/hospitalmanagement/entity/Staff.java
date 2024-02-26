package com.ast.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;

    @Column(name = "profile")
    private String profile;

    @Column(name = "phone_no", unique = true)
    private String phoneNo;

    @Column(name = "password")
    private String password;
}
