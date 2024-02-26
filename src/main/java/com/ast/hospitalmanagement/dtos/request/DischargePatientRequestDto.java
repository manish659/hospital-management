package com.ast.hospitalmanagement.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DischargePatientRequestDto {
    @JsonProperty("id")
    @NotNull(message = "id cant be null")
    private Integer id;

    @JsonProperty("room_id")
    @NotNull(message = "room_id cant be null")
    private Integer roomId;
}
