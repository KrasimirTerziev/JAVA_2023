package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import static com.company.oop.cosmetics.utils.ParsingHelpers.tryParseGender;

public abstract class ProductImpl implements Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setBrand(brand);
        setGender(gender);
        setName(name);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrandName() {
        return brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGenderType() {
        return gender;
    }

    @Override
    public String print() {
        return String.format("#%s %s%n" +
                " #Price: $%.2f%n" +
                " #Gender: %s%n", name, brand, price, gender);
    }

    private void setName(String name) {
        ValidationHelpers.validateStringLength(name, NAME_MIN_LENGTH, NAME_MAX_LENGTH, "Name");
        this.name = name;
    }

    private void setBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, BRAND_NAME_MIN_LENGTH, BRAND_NAME_MAX_LENGTH, "Brand");
        this.brand = brand;
    }

    private void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void setGender(GenderType gender) {
        if (gender.equals(tryParseGender(gender.toString()))) {
            this.gender = gender;
        }
    }
}
