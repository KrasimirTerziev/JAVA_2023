package com.company.oop.dealership.commands;

import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;

import java.util.List;

public class ShowUsersCommand extends BaseCommand {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    public ShowUsersCommand(VehicleDealershipRepository vehicleDealershipRepository) {
        super(vehicleDealershipRepository);
    }


    @Override
    protected String executeCommand(List<String> parameters) {
        return showUserNames();
    }

    private String showUserNames() {
        if (!getVehicleDealershipRepository().getLoggedInUser().isAdmin()) {
            throw new IllegalArgumentException("You are not an admin!");
        }
        return toString();
    }


    @Override
    protected boolean requiresLogin() {

        return true;
    }
}
