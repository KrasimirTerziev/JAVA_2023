package com.company.oop.dealership.models.enums;

public enum Priority {
    //High, Medium, or Low.
    HIGH,
    MEDIUM,
    LOW;

    public String toString() {
        switch (this) {
            case HIGH:
                return "High";
            case MEDIUM:
                return "Medium";
            case LOW:
                return "Low";
            default:
                return "Unknown";
        }
    }
}
