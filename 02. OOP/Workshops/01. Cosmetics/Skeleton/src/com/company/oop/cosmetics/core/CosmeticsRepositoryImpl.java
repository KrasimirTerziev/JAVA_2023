package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.Product;
import com.company.oop.cosmetics.models.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class CosmeticsRepositoryImpl implements CosmeticsRepository {


    private final List<Product> products;
    private final List<Category> categories;
    private final ShoppingCart shoppingCart;

    public CosmeticsRepositoryImpl() {
        products = new ArrayList<>();
        categories = new ArrayList<>();

        shoppingCart = new ShoppingCart();
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findProductByName(String productName) {
        for (int i = 0; i < products.size(); i++){
            if(products.get(i).getName().equals(productName)){
                return products.get(i);
            }
        }
        throw new IllegalArgumentException();
        /**
         * Hint: You have to go through every product and see if one has name equal to productName.
         *       If not, "throw new IllegalArgumentException("Product with this name does not exist");"
         */
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getName().equals(categoryName)){
                return categories.get(i);
            }
        }
        throw  new IllegalArgumentException();
        /**
         * Hint: You have to go through every category and see if one has name equal to categoryName.
         *       If not, "throw new IllegalArgumentException("Category with this name does not exist");"
         */
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void createCategory(String categoryName) {
        Category  category = new Category(categoryName);
        categories.add(category);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        Product product = new Product(name, brand, price, gender);
        products.add(product);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean categoryExist(String categoryName) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equals(categoryName)) {
                return true;
            }
        }
        /**
         * Hint: You have to go through every category and see if one has name equal to categoryName.
         *       If there is one, return true. If not, return false.
         */
        //throw new UnsupportedOperationException("Not implemented yet.");
        return false;
    }

    @Override
    public boolean productExist(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().equals(productName)){
                return true;
            }
        }
        return false;
        /**
         * Hint: You have to go through every product and see if one has name equal to productName.
         *       If there is one, return true. If not, return false.
         */
       //throw new UnsupportedOperationException("Not implemented yet.");
    }
}
