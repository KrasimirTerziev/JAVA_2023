package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Identifiable;

public abstract class VehicleImpl implements Identifiable {
    private int passengerCapacity;
    private double pricePerKilometer;
    private int id;
    private VehicleType type;

    public VehicleImpl(int id, int passengerCapacity, VehicleType type, double pricePerKilometer) {
        setPassengerCapacity(passengerCapacity);
        this.type = type;
        setPricePerKilometer(pricePerKilometer);
        this.id = id;
    }

    public int getPassengerCapacity(int passengerCapacity) {
        return this.passengerCapacity;
    }

    public double getPricePerKilometer(double price) {
        return pricePerKilometer;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }

    protected String print() {
        return null;
    }
    @Override
    public int getId() {
        return id;
    }
}
