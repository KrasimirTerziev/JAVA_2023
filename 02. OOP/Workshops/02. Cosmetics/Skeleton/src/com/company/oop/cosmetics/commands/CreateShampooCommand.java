package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.utils.ValidationHelpers;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;

import java.util.List;

public class CreateShampooCommand implements Command {

    private static final String CATEGORY_CREATED = "Shampoo with name %s was created!";
    private static final String CATEGORY_ALREADY_EXISTS = "Shampoo with name %s already exists!";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String productName = parameters.get(0);
        String productBrand = parameters.get(1);
        double productPrice = Double.parseDouble(parameters.get(2));
        GenderType productGender = GenderType.valueOf(parameters.get(3).toUpperCase());
        int productMilliliters = Integer.parseInt(parameters.get(4));
        UsageType productUsageType = UsageType.valueOf(parameters.get(5).toUpperCase());


        return createShampoo(productName,
                productBrand,
                productPrice,
                productGender,
                productMilliliters,
                productUsageType);
    }

    private String createShampoo(String productName,
                                 String productBrand,
                                 double productPrice,
                                 GenderType productGenderType,
                                 int productMilliliters,
                                 UsageType productUsageType) {

        if (cosmeticsRepository.productExist(productName)) {
            throw new IllegalArgumentException(String.format(CATEGORY_ALREADY_EXISTS, productName));
        }
        cosmeticsRepository.createShampoo(productName,
                productBrand,
                productPrice,
                productGenderType,
                productMilliliters,
                productUsageType);

        return String.format(CATEGORY_CREATED, productName);
    }
}
