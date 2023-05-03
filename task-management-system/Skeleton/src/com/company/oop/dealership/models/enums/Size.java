package com.company.oop.dealership.models.enums;

public enum Size {
    //Large, Medium, or Small
    LARGE,
    MEDIUM,
    SMALL;

    public String toString() {
        switch (this) {
            case LARGE:
                return "Large";
            case MEDIUM:
                return "Medium";
            case SMALL:
                return "Small";
            default:
                return "Unknown";
        }
    }
}
