package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Toothpaste;
import com.company.oop.cosmetics.models.enums.GenderType;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductImpl implements Toothpaste {

    private final List<String> ingredients;

    public ToothpasteImpl(String name, String brandName, double price, GenderType genderType, List<String> ingredients) {
        super(name, brandName, price, genderType);
        this.ingredients = new ArrayList<>(ingredients);
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    @Override
    public String print() {
        return String.format("%s" +
                        " #Ingredients: %s\n",
                super.print(),
                ingredients);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Compare Object reference
        if (o == null || getClass() != o.getClass()) return false; // Compare Classes full qualified name
        ToothpasteImpl toothpaste = (ToothpasteImpl) o; // Initialize o as Toothpaste object
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
}
