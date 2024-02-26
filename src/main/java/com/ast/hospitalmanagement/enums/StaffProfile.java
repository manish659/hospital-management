package com.ast.hospitalmanagement.enums;

public enum StaffProfile {
    Doctor("Doctor"),
    RECEPTIONIST("Receptionist");

    private final String profile;

    private StaffProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }
}
