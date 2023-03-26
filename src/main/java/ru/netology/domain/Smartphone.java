package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int amount, String manufacturer) {
        super(id, name, amount);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    @Override
    public boolean matches(String search) {
        if (super.matches(search) == false) {
            getManufacturer().contains(search);
            if (getManufacturer().contains(search) == true) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}