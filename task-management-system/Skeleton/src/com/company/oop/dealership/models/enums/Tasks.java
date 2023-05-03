package com.company.oop.dealership.models.enums;

public enum Tasks {
    BUG,
    STORY,
    FEEDBACK;

    @Override
    public String toString() {
        switch (this) {
            case BUG:
                return "Car";
            case STORY:
                return "Motorcycle";
            case FEEDBACK:
                return "Truck";
            default:
                throw new UnsupportedOperationException("Can't convert vehicle type.");
        }
    }
}


