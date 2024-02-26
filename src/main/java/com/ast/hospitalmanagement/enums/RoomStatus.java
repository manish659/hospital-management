package com.ast.hospitalmanagement.enums;

public enum RoomStatus {

    AVAILABLE("Available"),
    OCCUPIED("Occupied");

    private final String status;

    private RoomStatus(String status) {
        this.status = status;
    }

    public String getRoomStatus() {
        return status;
    }
}
