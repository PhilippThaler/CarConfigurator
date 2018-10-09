package com.philippthaler;

class Car {
    private CarBrand brand;
    private Model model;
    private Package carPackage;
    private double price;

    public Car() {
        price = 0;
    }

    public Car(Model model, Package carPackage, double price) {
        this.model = model;
        this.carPackage = carPackage;
        this.price = price;
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

    public boolean isCarFinished() {
        return brand != null && model != null && carPackage != null;
    }

    public void setCarPackage(Package carPackage) {
        this.carPackage = carPackage;
        updatePrice();
    }

    private void updatePrice() {
        price = ((model != null) ? model.getPrice() : 0) + ((carPackage != null) ? carPackage.getPrice() : 0);
    }

    @Override
    public String toString() {
        return String.format("\n\nModel:\t\t%-10s\nPackage:\t%10s\nPrice:\t\t\t\t\t\t\t\t%-6.2f\n\n", (model != null) ? model : "", (carPackage != null) ? carPackage : "", price);
    }
}
