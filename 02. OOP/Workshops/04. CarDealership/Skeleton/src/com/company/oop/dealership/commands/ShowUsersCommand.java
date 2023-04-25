package com.company.oop.dealership.commands;

import com.company.oop.dealership.models.UserImpl;
import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.User;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.UserRole;

import java.util.List;

public class ShowUsersCommand extends UserImpl implements User {


    @Override
    public void addVehicle(Vehicle vehicle) {
        //vehicles.add(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {

    }

    @Override
    public void addComment(Comment commentToAdd, Vehicle vehicleToAddComment) {

    }

    @Override
    public void removeComment(Comment commentToRemove, Vehicle vehicleToRemoveComment) {

    }
}
