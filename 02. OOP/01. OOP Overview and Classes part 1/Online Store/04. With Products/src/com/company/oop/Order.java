package com.company.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public String recipient;
    public LocalDate deliveryOn;
    public Currency currency;
    public List<Product> items;

    public Order(String recipient, Currency currency, LocalDate deliveryOn) {
        this.recipient = recipient;
        this.deliveryOn = deliveryOn;
        this.currency = currency;
        items = new ArrayList<>();
    }

    public void displayOrderItems() {
        if (items.size() == 0) {
            System.out.println("No items");
        }

        StringBuilder sb = new StringBuilder("Items:");
        for (Product item : items) {
            sb.append(String.format("  %s", item.getDisplayInfo()));
        }

        System.out.println(sb.toString());
    }

    public void displayGeneralInfo() {
        String dateFormat = deliveryOn.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));

        System.out.printf("Order to %s | Delivery on: %s | Total: %s",
                recipient,
                dateFormat,
                formatPrice());
    }

    public String formatPrice() {
        return String.format("%.2f %s", calculateTotalPrice(), currency);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product item : items) {
            total += item.price;
        }

        if (currency == Currency.BGN) {
            total = total * 1.75;
        }

        return total;
    }

}
