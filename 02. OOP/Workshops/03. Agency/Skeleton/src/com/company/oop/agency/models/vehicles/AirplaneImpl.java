package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane, Identifiable {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private int id;
    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, VehicleType type, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, type, pricePerKilometer);
        validatePassengerCapacity(passengerCapacity);
        validatePricePerKilometer(pricePerKilometer);
        this.hasFreeFood = hasFreeFood;
        this.id = id;
    }

    private void validatePassengerCapacity(int passengerCapacity) {
        if (getPricePerKilometer(passengerCapacity) >= PASSENGER_MIN_VALUE && getPricePerKilometer(passengerCapacity) <= PASSENGER_MAX_VALUE) {
            super.getPricePerKilometer(passengerCapacity);
        }
        throw new IllegalArgumentException();
    }
    private void validatePricePerKilometer(double pricePerKilometer) {
        if (getPricePerKilometer(pricePerKilometer) >= PRICE_MIN_VALUE && getPricePerKilometer(pricePerKilometer) <= PRICE_MAX_VALUE) {
            super.getPricePerKilometer(pricePerKilometer);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public int getId() {
        return id;
    }
}