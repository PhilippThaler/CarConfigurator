package com.philippthaler;

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

    @Override
    public String toString() {
        return name;
    }
}
