package com.philippthaler.app;

/**
 * @author philipp thaler
 * @version 1.0
 *
 * POJO class that represents a specific package for the car
 */
public class Package {
    private final String name;
    private final double price;

    public Package(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * @return a String representation of the price. Formatted with 2 decimal places
     */
    public String getPriceAsString() {
        return String.format("%.2f", price);
    }

    /**
     * @return a String representation of the Package, with name and price
     */
    @Override
    public String toString() {
        return String.format("%-10s\t\t%10.2f", name, price);
    }
}
