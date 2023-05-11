package com.company.oop.agency.models.contracts;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public interface Journey extends Printable, Identifiable{

    int getDistance();

    Vehicle getVehicle();

    String getStartLocation();

    String getDestination();

    double calculateTravelCosts();

}