package com.philippthaler;

public class Package {
    private String name;
    private double price;

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

    public String getPriceAsString() {
        return String.format("%.2f", price);
    }

    @Override
    public String toString() {
        return String.format("%-10s\t\t%10.2f", name, price);
    }
}
