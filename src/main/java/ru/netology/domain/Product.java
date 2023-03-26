package ru.netology.domain;

public class Product {
    protected int id;
    protected String name;
    protected int amount;

    public Product(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public boolean matches(String search) {
        if (getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

//public boolean matches(Product product, String search) {
//        return product.getName().contains(search);
//    }
}