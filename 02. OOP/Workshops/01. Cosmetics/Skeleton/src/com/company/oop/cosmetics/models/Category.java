package com.company.oop.cosmetics.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    public static final int NAME_MIN_LENGTH = 2;
    public static final int NAME_MAX_LENGTH = 15;

    private String name;

    public ArrayList<Product> collection = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
        if (name.length() >= NAME_MIN_LENGTH && name.length() <= NAME_MAX_LENGTH) {
            String name1 = this.name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Category(String name) {
        Category category = new Category(name);
    }

    public String getName() {
        return name;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<Product> getProducts() {
        return collection;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void addProduct(Product product) {
        collection.add(product);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void removeProduct(Product product) {
        if(this.collection.contains(product)){
            this.collection.remove(product);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public String print() {
        System.out.printf("#Category: %s%n", this.name);
        if(this.collection.isEmpty()){
            System.out.println("#No product in this category");
        }else{
            for(Product product : this.collection){
                System.out.printf(" #%s %s%n #Price: %s%n #Gender: %s%n ===%n",product.getName(), product.getBrand(), product.getPrice(), product.getGender());
            }
        }
        return null;
    }

}
