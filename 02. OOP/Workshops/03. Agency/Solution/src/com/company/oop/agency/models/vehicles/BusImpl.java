package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final String PASSENGER_ERROR_MESSAGE =
            "A bus cannot have less than 10 passengers or more than 50 passengers.";

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE);
    }

    @Override
    public String toString() {
        return String.format("Bus ----%n" +
                "%s", super.toString());
    }
}