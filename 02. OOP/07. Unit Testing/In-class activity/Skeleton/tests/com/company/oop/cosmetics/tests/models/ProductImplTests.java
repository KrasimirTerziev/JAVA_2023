package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ProductImplTests {
    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        String name = "Georgi";
        ProductImpl product = new ProductImpl("Georgi", "GBrand", 7.01, GenderType.UNISEX);
        assertEquals(name, product.getName());
    }
    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class, () ->
                new ProductImpl("Category name should be between 3 and 10 symbols.", "GBrand", 5, GenderType.MEN));
    }
    @Test
    public void constructor_Should_ThrowException_When_BrandIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class, () ->
                new ProductImpl("Georgi", "Category name should be between 2 and 10 symbols.", 5, GenderType.MEN));
    }
    @Test
    public void constructor_Should_ThrowException_When_PriceIsIncorrect() {
        double num = 10;
        Product product = new ProductImpl("Georgi", "GBrand", num, GenderType.WOMEN);
        assertEquals(num, product.getPrice());
    }
    @Test
    public void constructor_Should_ThrowException_When_GenderTypeIsIncorrect() {
        GenderType gender = GenderType.WOMEN;
        Product product = new ProductImpl("Georgi", "GBrand", 7, gender);
        assertEquals(gender, product.getGender());
    }
}
