package com.ast.hospitalmanagement.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddRoomRequestDto {

    @JsonProperty("room_no")
    @NotEmpty(message = "room_no cant be empty")
    private String roomNo;
}
