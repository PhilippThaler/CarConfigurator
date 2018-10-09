package com.philippthaler;

public class Model {
    private String name;
    private double price;
    private CarBrand brand;

    public Model(String name, double price, CarBrand brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
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

    public CarBrand getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10s\t\t %10.2f", brand.getName(), name, price);
    }
}
