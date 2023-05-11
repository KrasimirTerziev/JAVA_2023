package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.Arrays;
import java.util.List;

public class CreateToothpasteCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateToothpasteCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return createToothpaste(parameters);
    }

    private String createToothpaste(List<String> parameters) {
        String name = parameters.get(0);
        if (cosmeticsRepository.productExist(name)){
            throw new IllegalArgumentException(String.format(ParsingHelpers.PRODUCT_NAME_ALREADY_EXISTS, "Toothpaste", name));
        }
        String brandName = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        List<String> ingredients = Arrays.asList(parameters.get(4).split(","));
        cosmeticsRepository.createToothpaste(name, brandName, price, genderType, ingredients);
        return String.format(ParsingHelpers.PRODUCT_CREATED, Toothpaste.class.getSimpleName(), name);
    }

}