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
}