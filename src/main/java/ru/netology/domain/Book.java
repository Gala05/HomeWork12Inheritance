package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int amount, String author) {
        super(id, name, amount);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search) == false) {
            getAuthor().contains(search);
            if (getAuthor().contains(search) == true) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}