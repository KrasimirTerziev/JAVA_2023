package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    public static final String COSTS_POSITIVE_MESSAGE = "Value of 'costs' must be a positive number. Actual value: %.2f.";
    private int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double administrativeCosts) {
        setId(id);
        setJourney(journey);
        setAdministrativeCosts(administrativeCosts);
    }

    @Override
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Journey getJourney() {
        return journey;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public double calculatePrice() {
        return administrativeCosts * journey.calculateTravelCosts();
    }


    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    private void setAdministrativeCosts(double administrativeCosts) {
        if (administrativeCosts <= 0){
            throw new InvalidUserInputException(String.format(COSTS_POSITIVE_MESSAGE, administrativeCosts));
        }
            this.administrativeCosts = administrativeCosts;
    }

    @Override
    public String getAsString() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("Ticket ----%n" +
                "Destination: %s%n" +
                "Price: %.2f%n", journey.getDestination(), calculatePrice());
    }
}
