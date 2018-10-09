package com.philippthaler;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarConfigurator {

    private final Database database;
    private final Car car;

    public CarConfigurator() {
        database = new Database();
        car = new Car();
    }

    public void start() {
        System.out.println("Car configurator");

        boolean finish = false;

        while (!finish) {
            printCar();
            switch (input("Choose", Arrays.asList("Brand", "Model", "Package", "Order", "Quit"))) {
            case 1:
                chooseBrand();
                break;
            case 2:
                chooseModel();
                break;
            case 3:
                choosePackage();
                break;
            case 4:
                if (car.isCarFinished()) {
                    finish = true;
                    System.out.println("Your car will be ready in 2 weeks. Thank you!");
                } else {
                    System.out.println("Choose all aspects of the configuration first!");
                }
                break;
            case 5:
                finish = true;
                System.out.println("Bye.");
                break;
            default:
                System.out.println("ERROR");
            }
        }
    }

    private void chooseBrand() {
        List<CarBrand> brands = database.getBrands();
        int input = input("Choose the brand: ", brands);

        // If you had a model and you choose a different brand, the model gets deleted
        if (!brands.get(input - 1).equals(car.getBrand())) {
            car.setModel(null);
        }
        car.setBrand(brands.get(input - 1));
    }

    private void chooseModel() {
        List<Model> models = (car.getBrand() == null) ? database.getModels()
                : database.getModelsFromBrandName(car.getBrand().getName());
        int input = input("Choose the model:", models);

        // If the car hasn't got a package, this initializes it to the Minimal Package
        if (car.getModel() == null && car.getCarPackage() == null) {
            car.setCarPackage(database.getPackages().get(0));
        }
        car.setBrand(models.get(input - 1).getBrand());
        car.setModel(models.get(input - 1));
    }

    private void choosePackage() {
        List<Package> packages = database.getPackages();
        int input = input("Choose the configuration: ", packages);
        car.setCarPackage(packages.get(input - 1));
    }

    // Method to print the configuration of the car
    private void printCar() {
        if (car.getModel() == null && car.getBrand() == null && car.getCarPackage() == null) {
            return;
        }
        System.out.println("Your car: ");
        System.out.printf("\t\t%-10s %-10s %30s\n", (car.getBrand() != null) ? car.getBrand() : "",
                (car.getModel() != null) ? car.getModel().getName() : "",
                (car.getModel() != null) ? car.getModel().getPriceAsString() : "");
        if (car.getCarPackage() != null) {
            System.out.printf("\t\t%-10s package %33s\n", car.getCarPackage().getName(),
                    car.getCarPackage().getPriceAsString());
        }
        System.out.printf("\t\tPrice: %45s\n", car.getPriceAsString());
    }

    // Method to print all lists
    private void printList(List l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.printf("%2d. %-30s\n", (i + 1), l.get(i));
        }
    }

    // Method for the input
    // Checks if it's a number and in range
    private int input(String message, List list) {
        System.out.println(message);
        printList(list);
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println("Enter a number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Wrong input.");
                scanner.nextInt();
            }
            input = scanner.nextInt();
        } while (input > list.size() || input <= 0);

        return input;
    }
}
