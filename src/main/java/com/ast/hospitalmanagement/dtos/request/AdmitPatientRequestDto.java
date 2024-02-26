package com.ast.hospitalmanagement.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AdmitPatientRequestDto {
    @JsonProperty("name")
    @NotEmpty(message = "name cant be empty")
    private String name;

    @JsonProperty("age")
    @NotNull(message = "age cant be null")
    private Integer age;

    @JsonProperty("room_id")
    @NotNull(message = "room_id cant be empty")
    private Integer roomId;

    @JsonProperty("doctor_name")
    @NotEmpty(message = "doctor_name cant be empty")
    private String doctorName;

    @JsonProperty("phone_no")
    @NotEmpty(message = "phone_no cant be empty")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNo;
}
