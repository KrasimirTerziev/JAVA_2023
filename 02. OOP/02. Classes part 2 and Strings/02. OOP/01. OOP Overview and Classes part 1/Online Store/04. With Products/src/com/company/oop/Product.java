package com.company.oop;

public class Product {

    public String name;
    public double price;
    public Currency currency;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        currency = Currency.USD; // default currency for all products
    }

    public String getDisplayInfo() {
        return String.format("%s - %.2f %s", name, price, currency);
    }

}
