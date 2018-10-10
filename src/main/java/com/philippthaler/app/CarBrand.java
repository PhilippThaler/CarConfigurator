package com.philippthaler.app;

/**
 * @author philipp thaler
 * @version 1.0
 *
 * POJO class that represents a specific car brand.
 */
public class CarBrand {
    private final String name;

    public CarBrand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CarBrand && ((CarBrand) obj).getName().equals(name);
    }


    /**
     * @return the name of the brand
     */
    @Override
    public String toString() {
        return name;
    }
}
