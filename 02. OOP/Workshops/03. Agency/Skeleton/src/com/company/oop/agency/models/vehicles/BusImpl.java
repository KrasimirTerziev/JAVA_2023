package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleImpl implements Identifiable {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private int id;

    public BusImpl(int id, int passengerCapacity, VehicleType type, double pricePerKilometer) {
        super(id, passengerCapacity, type, pricePerKilometer);
        validatePassengerCapacity(passengerCapacity);
        validatePricePerKilometer(pricePerKilometer);
        this.id = id;
    }

    private void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, "A bus cannot have less than 10 passengers or more than 50 passengers.");
        super.getPassengerCapacity(passengerCapacity);
    }

    private void validatePricePerKilometer(double pricePerKilometer) {
        if (getPricePerKilometer(pricePerKilometer) >= PRICE_MIN_VALUE && getPricePerKilometer(pricePerKilometer) <= PRICE_MAX_VALUE) {
            super.getPricePerKilometer(pricePerKilometer);
        }
        throw new IllegalArgumentException();
    }

    @Override
    protected String print() {
        return String.format("Bus ----\n" +
                super.print());
    }

    @Override
    public int getId() {
        return id;
    }
}