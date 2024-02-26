package com.ast.hospitalmanagement.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PatientsResponseDto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("room_id")
    private Integer roomId;

    @JsonProperty("doctor_name")
    private String doctorName;

    @JsonProperty("admit_date")
    private LocalDateTime admitDate;
}
