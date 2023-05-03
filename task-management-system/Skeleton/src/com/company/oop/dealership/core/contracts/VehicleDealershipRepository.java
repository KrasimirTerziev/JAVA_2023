package com.company.oop.dealership.core.contracts;

import com.company.oop.dealership.models.contracts.*;

import java.util.List;

public interface VehicleDealershipRepository {

    List<Members> getUsers();

    Members getLoggedInUser();

    void addUser(Members userToAdd);

    Members findUserByUsername(String username);

    Car createCar(String make, String model, double price, int seats);

    Board createMotorcycle(String make, String model, double price, String category);

    Team createTruck(String make, String model, double price, int weightCapacity);

    Members createUser(String username, String firstName, String lastName, String password, UserRole userRole);

    Comment createComment(String content, String author);

    boolean hasLoggedInUser();

    void login(Members user);

    void logout();
}
