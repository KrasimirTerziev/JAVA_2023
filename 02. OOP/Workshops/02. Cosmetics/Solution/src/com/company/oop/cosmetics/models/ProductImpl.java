package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class ProductImpl implements Product {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 10;
    private static final int BRAND_NAME_MIN_LENGTH = 2;
    private static final int BRAND_NAME_MAX_LENGTH = 10;
    public static final String INVALID_PRICE = "Price cannot be negative";

    private String name;
    private String brandName;
    private double price;
    private final GenderType genderType;


    public ProductImpl(String name, String brandName, double price, GenderType genderType) {
        setName(name);
        setBrandName(brandName);
        setPrice(price);
        this.genderType = genderType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGenderType() {
        return genderType;
    }

    private void setName(String name) {
        nameValidator(name);
        this.name = name;
    }

    void nameValidator(String name) {
        ValidationHelpers.validateStringLength(
                name,
                NAME_MIN_LENGTH,
                NAME_MAX_LENGTH,
                "name"
        );
    }

    private void setBrandName(String brandName) {
        brandNameValidator(brandName);
        this.brandName = brandName;
    }

    void brandNameValidator(String brandName) {
        ValidationHelpers.validateStringLength(
                brandName,
                BRAND_NAME_MIN_LENGTH,
                BRAND_NAME_MAX_LENGTH,
                "brand name"
        );
    }

    //ToDo - Rework Tests
    private void setPrice(double price) {
        priceValidator(price);
        this.price = price;
    }

    void priceValidator(double price) {
        if (price < 0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s\n" +
                        " #Price: $%.2f\n" +
                        " #Gender: %s\n",
                name,
                brandName,
                price,
                genderType
        );
    }
}
