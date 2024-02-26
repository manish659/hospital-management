package com.ast.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "room_no", unique = true)
    private String roomNo;

    @Column(name = "status")
    private String status;
}
