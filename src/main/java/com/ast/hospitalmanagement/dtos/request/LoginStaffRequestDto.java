package com.ast.hospitalmanagement.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginStaffRequestDto {

    @JsonProperty("phone_no")
    @NotEmpty(message = "phone_no cant be empty")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNo;

    @JsonProperty("password")
    @NotEmpty(message = "password cant be empty")
    private String password;
}
