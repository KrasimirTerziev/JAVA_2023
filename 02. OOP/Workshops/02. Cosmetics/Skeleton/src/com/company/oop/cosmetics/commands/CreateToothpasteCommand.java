package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateToothpasteCommand implements Command {

    private static final String CATEGORY_CREATED = "Toothpaste with name %s was created!";
    private static final String CATEGORY_ALREADY_EXISTS = "Toothpaste with name %s already exists!";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateToothpasteCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String productName = parameters.get(0);
        String productBrand = parameters.get(1);
        double productPrice = Double.parseDouble(parameters.get(2));
        GenderType productGender = GenderType.valueOf(parameters.get(3).toUpperCase());
        List<String> productIngredients = new ArrayList<>(Arrays.asList(parameters.get(4).split(",")));


        return createShampoo(productName,
                productBrand,
                productPrice,
                productGender,
                productIngredients);
    }

    private String createShampoo(String productName,
                                 String productBrand,
                                 double productPrice,
                                 GenderType productGenderType,
                                 List<String> productIngredients) {

        if (cosmeticsRepository.productExist(productName)) {
            throw new IllegalArgumentException(String.format(CATEGORY_ALREADY_EXISTS, productName));
        }
        cosmeticsRepository.createShampoo(productName,
                productBrand,
                productPrice,
                productGenderType,
                productIngredients);

        return String.format(CATEGORY_CREATED, productName);
    }
}