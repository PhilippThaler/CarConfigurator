package com.philippthaler.app;

/**
 * @author philipp Thaler
 * @version 1.0
 *
 * Class that represents a car
 * It has a brand (VW), a model (Golf) and a package (minimal, sport, luxury)
 * And a price, which is automatically generated
 */

class Car {
    private CarBrand brand;
    private Model model;
    private Package carPackage;
    private double price;

    public Car() {
        price = 0;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public Package getCarPackage() {
        return carPackage;
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

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public void setModel(Model model) {
        this.model = model;
        updatePrice();
    }

    /**
     * @return If the brand, the model and the package ar all chosen, return true, if not, return false.
     */
    public boolean isCarFinished() {
        return brand != null && model != null && carPackage != null;
    }

    public void setCarPackage(Package carPackage) {
        this.carPackage = carPackage;
        updatePrice();
    }

    /**
     * Helper Method that automatically updates the price
     */
    private void updatePrice() {
        price = ((model != null) ? model.getPrice() : 0) + ((carPackage != null) ? carPackage.getPrice() : 0);
    }

    /**
     * @return a String representation of the car. Displays the brand (if chosen), the model (if chosen) and the package (if chosen)
     */
    @Override
    public String toString() {
        return String.format("\n\nModel:\t\t%-10s\nPackage:\t%10s\nPrice:\t\t\t\t\t\t\t\t%-6.2f\n\n", (model != null) ? model : "", (carPackage != null) ? carPackage : "", price);
    }
}
