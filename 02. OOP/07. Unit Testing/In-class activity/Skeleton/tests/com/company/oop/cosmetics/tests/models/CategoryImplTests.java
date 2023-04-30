package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CategoryImplTests {

    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        String name = "Georgi";
        CategoryImpl category = new CategoryImpl(name);
        assertEquals(name, category.getName());
    }

    @Test
    public void constructor_Should_InitializeProducts_When_ArgumentsAreValid() {
        Category category = new CategoryImpl("Georgi");
        Product product = new ProductImpl("Georgi", "Georgi more than 10 symbols", 5, GenderType.MEN);
        category.addProduct(product);
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class, () ->
                new CategoryImpl("Category name should be between 3 and 10 symbols."));
    }

    @Test
    public void addProduct_Should_AddProductToList() {
        Category category = new CategoryImpl("Georgi");
        ProductImpl product = new ProductImpl("Georgi", "Georgi more than 10 symbols", 5, GenderType.MEN);
        category.addProduct(product);
        Assertions.assertEquals(category.getProducts().size(), 1);
    }

    @Test
    public void removeProduct_Should_RemoveProductFromList_When_ProductExist() {
        Category category = new CategoryImpl("Georgi");
        ProductImpl product = new ProductImpl("Georgi", "Georgi more than 10 symbols", 5, GenderType.MEN);
        category.addProduct(product);
        category.removeProduct(product);
        Assertions.assertEquals(category.getProducts().size(), 0);
    }

    @Test
    public void removeProduct_should_notRemoveProductFromList_when_productNotExist() {
        Category category = new CategoryImpl("Georgi");
        ProductImpl product = new ProductImpl("Georgi", "Georgi more than 10 symbols", 5, GenderType.MEN);
        category.removeProduct(product);
        Assertions.assertEquals(category.getProducts().size(), 0);
    }

}
