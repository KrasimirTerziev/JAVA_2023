package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleImpl implements Identifiable {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private int id;
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, VehicleType.LAND, pricePerKilometer);
        validatePassengerCapacity(passengerCapacity);
        validateCarts(carts);
        validatePrice(pricePerKilometer);
        this.id = id;
    }
    private void validatePassengerCapacity(int passengerCapacity){
        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, "A train cannot have less than 30 passenger or more than 150 passenger.");
        super.getPassengerCapacity(passengerCapacity);
    }
    private void validateCarts(int carts) {
        ValidationHelper.validateValueInRange(carts,CARTS_MIN_VALUE, CARTS_MAX_VALUE, "A train cannot have less than 1 cart or more than 15 carts.");
        super.getPassengerCapacity(carts);
        this.carts = carts;
    }
    private void validatePrice(double price) {
        if(getPricePerKilometer(price) >= PRICE_MIN_VALUE && getPricePerKilometer(price) <= PRICE_MAX_VALUE){
            super.getPricePerKilometer(price);
        }
        throw new IllegalArgumentException();
    }
    @Override
    public String print() {
        return String.format("Train ----\n" +
                        super.print() + "\n" +
                        "Carts amount: %d\n",
                carts);
    }
    @Override
    public int getId() {
        return id;
    }
}