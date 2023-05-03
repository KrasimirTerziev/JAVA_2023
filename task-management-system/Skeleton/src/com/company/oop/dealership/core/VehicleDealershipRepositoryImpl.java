package com.company.oop.dealership.core;


import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.company.oop.dealership.models.*;
import com.company.oop.dealership.models.contracts.*;

import java.util.ArrayList;
import java.util.List;


public class VehicleDealershipRepositoryImpl implements VehicleDealershipRepository {

    private static final String NO_LOGGED_IN_USER = "There is no logged in user.";
    private final static String NO_SUCH_USER = "There is no user with username %s!";
    private final static String USER_ALREADY_EXIST = "User %s already exist. Choose a different username!";

    private final List<Members> users;
    private Members loggedUser;

    public VehicleDealershipRepositoryImpl() {
        this.users = new ArrayList<>();
        this.loggedUser = null;
    }

    @Override
    public List<Members> getUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public void addUser(Members userToAdd) {
        if (users.contains(userToAdd)) {
            throw new IllegalArgumentException(String.format(USER_ALREADY_EXIST, userToAdd.getUsername()));
        } else {
            this.users.add(userToAdd);
        }
    }

    @Override
    public Members findUserByUsername(String username) {
        Members user = users
                .stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NO_SUCH_USER, username)));
        return user;
    }

    @Override
    public Members getLoggedInUser() {
        if (loggedUser == null) {
            throw new IllegalArgumentException(NO_LOGGED_IN_USER);
        }
        return loggedUser;
    }

    @Override
    public boolean hasLoggedInUser() {
        return loggedUser != null;
    }

    @Override
    public void login(Members user) {
        loggedUser = user;
    }

    @Override
    public void logout() {
        loggedUser = null;
    }

    @Override
    public Car createCar(String make, String model, double price, int seats) {
        return new CarImpl(make, model, price, seats);
    }

    @Override
    public Board createMotorcycle(String make, String model, double price, String category) {
        return new MotorcycleImpl(make, model, price, category);
    }

    @Override
    public Team createTruck(String make, String model, double price, int weightCapacity) {
        return new TeamImpl(make, model, price, weightCapacity);
    }




    @Override
    public Members createUser(String username, String firstName, String lastName, String password, UserRole userRole) {
        return new UserImpl(username, firstName, lastName, password, userRole);
    }

    @Override
    public Comment createComment(String content, String author) {
        return new CommentImpl(content, author);
    }
}