package com.company.oop.dealership.commands;

import com.company.oop.dealership.core.VehicleDealershipRepositoryImpl;
import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Members;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.company.oop.dealership.commands.LoginTests.loginInitializedUserToRepository;
import static com.company.oop.dealership.models.CarImplTests.initializeTestCar;
import static com.company.oop.dealership.models.CommentImplTests.*;
import static com.company.oop.dealership.utils.TestUtilities.getList;

public class RemoveCommentTests {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;

    private RemoveCommentCommand removeCommentCommand;
    private Members user;

    @BeforeEach
    public void before() {
        VehicleDealershipRepository repository = new VehicleDealershipRepositoryImpl();
        removeCommentCommand = new RemoveCommentCommand(repository);
        user = loginInitializedUserToRepository(repository);
    }

    @Test
    public void should_ThrowException_When_ArgumentCountDifferentThanExpected() {
        // Arrange
        List<String> params = getList(EXPECTED_NUMBER_OF_ARGUMENTS - 1);

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> removeCommentCommand.execute(params));
    }

    @Test
    public void should_ThrowException_When_VehicleIndexIsInvalid() {
        // Arrange
        Comment testComment = initializeTestComment();
        Car testCar = initializeTestCar();
        user.addComment(testComment, testCar);
        List<String> params = List.of(
                "INVALID_INDEX",
                "1",
                user.getUsername());

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> removeCommentCommand.execute(params));
    }

    @Test
    public void should_ThrowException_When_CommentIndexIsInvalid() {
        // Arrange
        Comment testComment = initializeTestComment();
        Car testCar = initializeTestCar();
        user.addComment(testComment, testCar);
        List<String> params = List.of(
                "1",
                "INVALID_INDEX",
                user.getUsername());

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> removeCommentCommand.execute(params));
    }

    @Test
    public void should_ThrowException_When_VehicleDoesNotExist() {
        // Arrange
        Comment testComment = initializeTestComment();
        Car testCar = initializeTestCar();
        user.addComment(testComment, testCar);
        List<String> params = List.of(
                "1",
                "1",
                user.getUsername());

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> removeCommentCommand.execute(params));
    }

    @Test
    public void should_ThrowException_When_CommentDoesNotExist() {
        // Arrange
        Car testCar = initializeTestCar();
        user.addVehicle(testCar);
        List<String> params = List.of(
                "1",
                "1",
                user.getUsername());

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> removeCommentCommand.execute(params));
    }


    @Test
    public void should_RemoveCommentFromUser_When_ArgumentsAreValid() {
        // Arrange
        Comment testComment = initializeTestComment();
        Car testCar = initializeTestCar();
        user.addVehicle(testCar);
        user.addComment(testComment, testCar);

        // Act
        removeCommentCommand.executeCommand(List.of(
                "1",
                "1",
                user.getUsername()
        ));

        // Act, Assert
        Assertions.assertEquals(0, user.getVehicles().get(0).getComments().size());
    }
}
