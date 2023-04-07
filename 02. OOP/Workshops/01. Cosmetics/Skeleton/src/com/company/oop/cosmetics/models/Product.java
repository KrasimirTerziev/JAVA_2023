package com.company.oop.cosmetics.models;

import java.util.Objects;

public class Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_MIN_LENGTH = 2;
    public static final int BRAND_MAX_LENGTH = 10;

    // "Each product in the system has name, brand, price and gender."
    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        // finish the constructor and validate data
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException();
        }
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public String getName() {
        return name;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    private void setName(String name) {
        if (name.length() >= NAME_MIN_LENGTH && name.length() <= NAME_MAX_LENGTH) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getPrice() {
        return price;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public String getBrand() {
        return brand;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    private void setBrand(String brand) {
        if (brand.length() >= BRAND_MIN_LENGTH && brand.length() <= BRAND_MAX_LENGTH) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public GenderType getGender() {
        return gender;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    private void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String print() {
       return String.format("#%s %s \n#Price:%.2f\n#Gender:%s\n==\n", name, brand, price, gender.toString());
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Product product = (Product) p;
        return Double.compare(this.getPrice(), product.getPrice()) == 0 &&
                Objects.equals(this.getName(), product.getName()) &&
                Objects.equals(this.getBrand(), product.getBrand()) &&
                this.getGender() == product.getGender();
    }

}
