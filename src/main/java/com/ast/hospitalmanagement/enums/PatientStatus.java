package com.ast.hospitalmanagement.enums;


public enum PatientStatus {
    ADMITTED("Admitted"),
    DISCHARGED("Discharged");

    private final String status;

    private PatientStatus(String status) {
        this.status = status;
    }

    public String getPatientStatus() {
        return status;
    }
}
