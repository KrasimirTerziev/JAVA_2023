package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;
    public static final String DISTANCE_ERROR_MESSAGE = "The Distance cannot be less than 5 or more than 5000 kilometers.";
    public static final String DESTINATION_ERROR_MESSAGE = "The Destination's length cannot be less than 5 or more than 25 symbols long.";
    public static final String START_LOCATION_ERROR = "The StartingLocation's length cannot be less than 5 or more than 25 symbols long.";

    private int id;
    private int distance;
    private String destination;
    private String startLocation;
    private Vehicle vehicle;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        setId(id);
        setDistance(distance);
        setDestination(destination);
        setStartLocation(startLocation);
        setVehicle(vehicle);

    }

    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        ValidationHelper.validateValueInRange(distance,
                DISTANCE_MIN_VALUE,
                DISTANCE_MAX_VALUE,
                DISTANCE_ERROR_MESSAGE);
        this.distance = distance;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {
        return distance * vehicle.getPricePerKilometer();
    }

    private void setDestination(String destination) {
        ValidationHelper.validateStringLength(destination,
                DESTINATION_MIN_LENGTH,
                DESTINATION_MAX_LENGTH,
                DESTINATION_ERROR_MESSAGE);
        this.destination = destination;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    private void setStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(startLocation,
                START_LOCATION_MIN_LENGTH,
                START_LOCATION_MAX_LENGTH,
                START_LOCATION_ERROR);
        this.startLocation = startLocation;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getAsString() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("Journey ----%n" +
                "Start location: %s%n" +
                "Destination: %s%n" +
                "Distance: %d%n" +
                "Vehicle type: %s%n" +
                "Travel costs: %.2f%n", startLocation, destination, distance, vehicle.getType(), calculateTravelCosts());
    }
}