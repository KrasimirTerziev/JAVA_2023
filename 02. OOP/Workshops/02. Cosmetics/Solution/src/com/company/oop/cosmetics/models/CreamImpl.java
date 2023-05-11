package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Cream;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.ScentType;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class CreamImpl extends ProductImpl implements Cream {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 15;
    private static final int BRAND_NAME_MIN_LENGTH = 3;
    private static final int BRAND_NAME_MAX_LENGTH = 15;
    public static final String INVALID_PRICE = "Price cannot be negative";

    private final ScentType scentType;

    public CreamImpl(String name, String brandName, double price, GenderType genderType, ScentType scentType) {
        super(name, brandName, price, genderType);
        this.scentType = scentType;
    }

    @Override
    public ScentType getScentType() {
        return scentType;
    }

    @Override
    void nameValidator(String name) {
        ValidationHelpers.validateStringLength(
                name,
                NAME_MIN_LENGTH,
                NAME_MAX_LENGTH,
                "name"
        );
    }

    @Override
    void brandNameValidator(String brandName) {
        ValidationHelpers.validateStringLength(
                brandName,
                BRAND_NAME_MIN_LENGTH,
                BRAND_NAME_MAX_LENGTH,
                "brand name"
        );
    }

    @Override
    void priceValidator(double price) {
        if (price <= 0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreamImpl cream = (CreamImpl) o;
        return getName().equals(cream.getName()) &&
                getBrandName().equals(cream.getBrandName()) &&
                getPrice() == cream.getPrice() &&
                this.getGenderType().equals(cream.getGenderType()) &&
                getScentType().equals(cream.getScentType());
    }


}
