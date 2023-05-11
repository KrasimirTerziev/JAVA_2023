package com.company.oop.agency.models.vehicles;


import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleBase implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final String CARTS_ERROR_MESSAGE = "A train cannot have less than 1 cart or more than 15 carts.";
    public static final String PASSENGER_ERROR_MESSAGE = "A train cannot have less than 30 passengers or more than 150 passengers.";

    private int carts;


    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer);
        setCarts(carts);
    }

    @Override
    public int getCarts() {
        return carts;
    }

    private void setCarts(int carts) {
        ValidationHelper.validateValueInRange(carts,
                CARTS_MIN_VALUE,
                CARTS_MAX_VALUE,
                CARTS_ERROR_MESSAGE);
        this.carts = carts;
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }

    @Override
    public String toString() {
        return String.format("Train ----%n" +
                "%s" +
                "Carts amount: %d%n", super.toString(), carts);
    }
}