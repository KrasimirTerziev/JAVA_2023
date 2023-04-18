package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Shampoo;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;

public class ShampooImpl extends ProductImpl implements Shampoo {

    private int milliliters;
    private UsageType usageType;

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usage) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        setUsageType(usageType);
    }
    @Override
    public int getMillilitres() {
        return milliliters;
    }

    @Override
    public UsageType getUsageType() {
        return usageType;
    }

    private void setMilliliters(int milliliters) {
        this.milliliters = milliliters;
    }

    private void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    @Override
    public String print() {
        return String.format("%s #Milliliters: %d%n #Usage: %s%n", super.print(),getMillilitres(),getUsageType().toString());
    }
    //This method should be uncommented when you are done with the class.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShampooImpl shampoo = (ShampooImpl) o;
        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }
}
