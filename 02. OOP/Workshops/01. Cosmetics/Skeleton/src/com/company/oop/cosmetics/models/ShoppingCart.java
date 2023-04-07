package com.company.oop.cosmetics.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void removeProduct(Product product) {
        products.remove(product);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public boolean containsProduct(Product product) {
        return products.contains(product);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public double totalPrice() {
        double sum = 0;
        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).getPrice();
        }
        return sum;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
