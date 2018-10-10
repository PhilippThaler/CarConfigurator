package com.philippthaler.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author philipp thaler
 * @version 1.0
 *
 * Database class, that holds all car brands, models and packages
 */

class Database {

    private final Map<String, CarBrand> brands = Map.ofEntries(
            Map.entry("VW", new CarBrand("VW")),
            Map.entry("Audi", new CarBrand("Audi")),
            Map.entry("Toyota", new CarBrand("Toyota")),
            Map.entry("Kia", new CarBrand("Kia"))
    );

    private final List<Model> models = Arrays.asList(
            // VW models
            new Model("Golf", 20015, brands.get("VW")),
            new Model("Polo", 14999, brands.get("VW")),
            new Model("Passat", 22995, brands.get("VW")),
            new Model("Tiguan", 24595, brands.get("VW")),
            // Audi models
            new Model("A3", 26790, brands.get("Audi")),
            new Model("A5", 37290, brands.get("Audi")),
            new Model("A7", 77100, brands.get("Audi")),
            new Model("Q5", 56250, brands.get("Audi")),
            // Toyota models
            new Model("Aygo", 9990, brands.get("Toyota")),
            new Model("Yaris", 10990, brands.get("Toyota")),
            new Model("Auris", 15990, brands.get("Toyota")),
            new Model("Prius", 29990, brands.get("Toyota")),
            new Model("RAV4", 31790, brands.get("Toyota")),
            // Kia Models
            new Model("Rio", 11990, brands.get("Kia")),
            new Model("Ceed", 16590, brands.get("Kia"))
    );

    private final List<Package> packages = Arrays.asList(
            new Package("Minimal", 0),
            new Package("Sport", 4000),
            new Package("Luxus", 10000)
    );

    /**
     * Creates a database
     */
    public Database() {

    }

    /**
     * @return a List of all models
     */
    public List<Model> getModels() {
        return models;
    }

    /**
     * @param brand String representation of a brand
     * @return a List of models which have the specified brand
     */
    // Returns a List of all models with a specific brand name
    public List<Model> getModelsFromBrandName(String brand) {
        return models.stream().filter((model -> model.getBrand().getName().equals(brand))).collect(Collectors.toList());
    }

    /**
     * @return a List of all brands
     */
    public List<CarBrand> getBrands() {
        return brands.keySet().stream().map(CarBrand::new).collect(Collectors.toList());
    }


    /**
     * @return a List of all packages
     */
    public List<Package> getPackages() {
        return packages;
    }
}
