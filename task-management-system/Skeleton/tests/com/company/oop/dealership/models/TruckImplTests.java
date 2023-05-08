package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Team;
import com.company.oop.dealership.models.contracts.Tasks;
import com.company.oop.dealership.utils.VehicleBaseConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TruckImplTests {
    public static final int WEIGHT_CAP_MIN = 1;
    public static final int VALID_WEIGHT_CAP = WEIGHT_CAP_MIN + 1;

    @Test
    public void truckImpl_Should_ImplementTruckInterface() {
        // Arrange, Act
        TeamImpl truck = initializeTestTruck();
        // Assert
        assertTrue(truck instanceof Team);
    }

    @Test
    public void truckImpl_Should_ImplementVehicleInterface() {
        // Arrange, Act
        TeamImpl truck = initializeTestTruck();
        // Assert
        assertTrue(truck instanceof Tasks);
    }

    @Test
    public void constructor_Should_ThrowException_When_MakeNameLengthOutOfBounds() {
        // Arrange, Act, Assert
        assertThrows(IllegalArgumentException.class, () ->
                new TeamImpl(
                        VehicleBaseConstants.INVALID_MAKE,
                        VehicleBaseConstants.VALID_MODEL,
                        VehicleBaseConstants.VALID_PRICE,
                        VALID_WEIGHT_CAP));
    }

    @Test
    public void constructor_Should_ThrowException_When_ModelNameLengthOutOfBounds() {
        // Arrange, Act, Assert
        assertThrows(IllegalArgumentException.class, () ->
                new TeamImpl(
                        VehicleBaseConstants.VALID_MAKE,
                        VehicleBaseConstants.INVALID_MODEL,
                        VehicleBaseConstants.VALID_PRICE,
                        VALID_WEIGHT_CAP));
    }

    @Test
    public void constructor_Should_ThrowException_When_PriceIsInvalid() {
        // Arrange, Act, Assert
        assertThrows(IllegalArgumentException.class, () ->
                new TeamImpl(
                        VehicleBaseConstants.VALID_MAKE,
                        VehicleBaseConstants.VALID_MODEL,
                        -1,
                        VALID_WEIGHT_CAP));
    }

    @Test
    public void constructor_Should_ThrowException_When_WeightIsInvalid() {
        // Arrange, Act, Assert
        assertThrows(IllegalArgumentException.class, () ->
                new TeamImpl(
                        VehicleBaseConstants.VALID_MAKE,
                        VehicleBaseConstants.VALID_MODEL,
                        VehicleBaseConstants.VALID_PRICE,
                        -1));
    }

    @Test
    public void constructor_Should_CreateNewTruck_When_ParametersAreCorrect() {
        // Arrange, Act
        TeamImpl truck = initializeTestTruck();

        // Assert
        assertEquals(VehicleBaseConstants.VALID_MAKE, truck.getMake());
    }

    public static TeamImpl initializeTestTruck() {
        return new TeamImpl(
                VehicleBaseConstants.VALID_MAKE,
                VehicleBaseConstants.VALID_MODEL,
                VehicleBaseConstants.VALID_PRICE,
                VALID_WEIGHT_CAP);
    }
}