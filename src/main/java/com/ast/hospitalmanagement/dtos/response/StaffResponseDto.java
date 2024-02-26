package com.ast.hospitalmanagement.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StaffResponseDto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("first_name")
    private String fName;

    @JsonProperty("last_name")
    private String lName;

    @JsonProperty("profile")
    private String profile;

    @JsonProperty("phone_no")
    private String phoneNo;
}
