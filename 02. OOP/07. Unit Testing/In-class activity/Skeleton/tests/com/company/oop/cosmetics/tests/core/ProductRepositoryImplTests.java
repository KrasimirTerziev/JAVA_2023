package com.company.oop.cosmetics.tests.core;

import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProductRepositoryImplTests {

    @Test
    public void constructor_Should_InitializeProducts() {
        //Arrange
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        //Act
        List<Product> products = repository.getProducts();
        //Assert
        assertTrue(products.isEmpty());

    }

    @Test
    public void constructor_Should_InitializeCategories() {
        ProductRepositoryImpl repository = new ProductRepositoryImpl();
        List<Category> categories = repository.getCategories();
        assertTrue(categories.isEmpty());
    }

    @Test
    public void getCategories_Should_ReturnCopyOfCollection() {
    }

    @Test
    public void getProducts_Should_ReturnCopyOfCollection() {
    }

    @Test
    public void categoryExists_Should_ReturnTrue_When_CategoryExists() {

    }

    @Test
    public void categoryExists_Should_ReturnFalse_When_CategoryDoesNotExist() {

    }

    @Test
    public void productExists_Should_ReturnTrue_When_ProductExists() {

    }

    @Test
    public void productExists_Should_ReturnFalse_When_ProductDoesNotExist() {

    }

    @Test
    public void createProduct_Should_AddToProducts_When_ArgumentsAreValid() {

    }

    @Test
    public void createCategory_Should_AddToCategories_When_ArgumentsAreValid() {

    }

    @Test
    public void findCategoryByName_Should_ReturnCategory_When_Exists() {

    }

    @Test
    public void findCategoryByName_Should_ThrowException_When_DoesNotExist() {

    }

    @Test
    public void findProductByName_Should_ReturnCategory_When_Exists() {

    }

    @Test
    public void findProductByName_Should_ThrowException_When_DoesNotExist() {

    }

}
